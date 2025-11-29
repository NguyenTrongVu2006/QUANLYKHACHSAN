import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Sử dụng ArrayList trực tiếp để lưu trữ Đặt phòng
    private static List<DATPHONG> danhSachDatPhong = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QUANLYPHONG qlPhong = new QUANLYPHONG();
        QUANLYKHACHHANG qlKH = new QUANLYKHACHHANG();
        QUANLYNHANVIEN qlNV = new QUANLYNHANVIEN();
        QUANLYHOADON qlHD = new QUANLYHOADON();

        while (true) {
            System.out.println("\n====== QUẢN LÝ KHÁCH SẠN ======");
            System.out.println("1. Quản lý phòng");
            System.out.println("2. Quản lý khách hàng (và Đặt phòng)");
            System.out.println("3. Quản lý nhân viên");
            System.out.println("4. Quản lý hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1:
                    menuPhong(sc, qlPhong);
                    break;
                case 2:
                    menuKhachHang(sc, qlKH, qlPhong, danhSachDatPhong, qlNV);
                    break;
                case 3:
                    menuNhanVien(sc, qlNV);
                    break;
                case 4:
                    menuHoaDon(sc, qlHD, qlKH, qlNV, qlPhong, danhSachDatPhong);
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, thử lại!");
            }
        }
    }
    // HÀM HỖ TRỢ: Tìm kiếm DATPHONG
    private static DATPHONG timKiemDatPhong(String maDatPhong, List<DATPHONG> danhSach) {
        for (DATPHONG dp : danhSach) {
            // Cần kiểm tra dp.getMaDatPhong() có null không
            if (dp.getMaDatPhong() != null && dp.getMaDatPhong().equals(maDatPhong)) {
                return dp;
            }
        }
        return null;
    }

    private static void menuPhong(Scanner sc, QUANLYPHONG qlPhong) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ PHÒNG ---");
            System.out.println("1. Thêm phòng");
            System.out.println("2. Xóa phòng");
            System.out.println("3. Cập nhật phòng");
            System.out.println("4. Tìm phòng");
            System.out.println("5. Hiển thị tất cả phòng");
            System.out.println("6. Quay lại menu chính");
            System.out.print("Chọn: ");
            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số!");
                continue;
            }
            switch (chon) {
                case 1:
                    System.out.println("Chọn phòng (1: Phòng đơn, 2: Phòng đôi): ");
                    int loai;
                    try {
                        loai = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Lựa chọn không hợp lệ!");
                        break;
                    }
                    PHONG phong;
                    if (loai == 1) {
                        phong = new PHONGDON();
                    } else {
                        phong = new PHONGDOI();
                    }
                    phong.Nhap();
                    qlPhong.themPhong(phong);
                    break;
                case 2:
                    System.out.print("Nhập mã phòng cần xóa: ");
                    String maXoa = sc.nextLine();
                    qlPhong.xoaPhong(maXoa);
                    break;
                case 3:
                    System.out.print("Nhập mã phòng cần cập nhật: ");
                    String maCapNhat = sc.nextLine();
                    PHONG capNhapPhong = qlPhong.timKiemPhong(maCapNhat);
                    if (capNhapPhong == null){
                        System.out.println("không tìm thấy mã phòng!");
                        break;
                    }
                    PHONG pMoi;
                    System.out.println("Chọn phòng mới (1: Phòng đơn, 2: Phòng đôi): ");
                    int loaiMoi;
                    try {
                        loaiMoi = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Lựa chọn không hợp lệ!");
                        break;
                    }
                    if (loaiMoi == 1) pMoi = new PHONGDON();
                    else pMoi = new PHONGDOI();
                    pMoi.Nhap();
                    qlPhong.capNhatPhong(maCapNhat, pMoi);
                    break;
                case 4:
                    System.out.print("Nhập mã phòng cần tìm: ");
                    String maTim = sc.nextLine();
                    PHONG phongTim = qlPhong.timKiemPhong(maTim);
                    if (phongTim != null) phongTim.hienThiThongTin();
                    else System.out.println("Không tìm thấy phòng!");
                    break;
                case 5:
                    qlPhong.hienThiTatCa();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void menuKhachHang(Scanner sc, QUANLYKHACHHANG qlKH, QUANLYPHONG qlPhong, List<DATPHONG> danhSachDatPhong, QUANLYNHANVIEN qlNV) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ KHÁCH HÀNG ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Xóa khách hàng");
            System.out.println("3. Cập nhật khách hàng");
            System.out.println("4. Tìm khách hàng");
            System.out.println("5. Hiển thị tất cả khách hàng");
            System.out.println("6. Đặt phòng");
            System.out.println("7. Xem lịch sử đặt phòng");
            System.out.println("8. Quay lại menu chính");
            System.out.print("Chọn: ");
            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số!");
                continue;
            }
            switch (chon) {
                case 1:
                    KHACHHANG kh = new KHACHHANG();
                    kh.Nhap();
                    qlKH.themKhachHang(kh);
                    break;
                case 2:
                    System.out.print("Nhập mã khách hàng cần xóa: ");
                    qlKH.xoaKhachHang(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhập mã khách hàng cần cập nhật: ");
                    String maCapNhat = sc.nextLine();
                    KHACHHANG capnhatKH = qlKH.timKiem(maCapNhat);
                    if(capnhatKH == null) {
                        System.out.println("không tìm thấy mã khách hàng!");
                        break;
                    }
                    KHACHHANG khMoi = new KHACHHANG();
                    khMoi.Nhap();
                    qlKH.capNhatKhachHang(maCapNhat, khMoi);
                    break;
                case 4:
                    System.out.print("Nhập mã khách hàng cần tìm: ");
                    KHACHHANG khTim = qlKH.timKiem(sc.nextLine());
                    // Cần xử lý trường hợp khTim.toString() không tồn tại nếu không có @Override trong KHACHHANG
                    if (khTim != null)
                        khTim.hienThiThongTin();
                    else System.out.println("Không tìm thấy khách hàng!");
                    break;
                case 5:
                    qlKH.hienThiTatCa();
                    break;
                case 6:
                    // 1. Kiểm tra Khách hàng
                    System.out.print("Nhập mã khách hàng đặt phòng: ");
                    String maKH = sc.nextLine();
                    KHACHHANG khDat = qlKH.timKiem(maKH);
                    if (khDat == null) {
                        System.out.println("Không tìm thấy khách hàng!");
                        break;
                    }
                    // 2. Kiểm tra Phòng
                    System.out.print("Nhập mã phòng muốn đặt: ");
                    String maPhong = sc.nextLine();
                    PHONG p = qlPhong.timKiemPhong(maPhong);
                    if (p == null) {
                        System.out.println("Không tìm thấy phòng!");
                        break;
                    }
                    if (p.getTrangThai().equalsIgnoreCase("Da dat")) {
                        System.out.println("Lỗi: Phòng đã được đặt!");
                        break;
                    }
                    // 3. Kiểm tra Nhân viên xử lý (Có thể bỏ qua nếu không cần thiết)
                    System.out.print("Nhập mã nhân viên xử lý đơn: ");
                    NHANVIEN nvXuLy = qlNV.timKiemNV(sc.nextLine());
                    if (nvXuLy == null) {
                        System.out.println("Lưu ý: Không tìm thấy nhân viên. Tiếp tục không gán NV.");
                    }
                    // 4. Nhập thông tin ĐẶT PHÒNG
                    DATPHONG dp = new DATPHONG();
                    dp.Nhap();
                    // 5. Kiểm tra trùng Mã Đặt phòng
                    if (timKiemDatPhong(dp.getMaDatPhong(), danhSachDatPhong) != null) {
                        System.out.println("Lỗi: Mã đặt phòng này đã tồn tại. Thử lại.");
                        break;
                    }
                    // 6. Gán mối quan hệ
                    dp.setKh(khDat);
                    dp.setP(p);
                    dp.setNv(nvXuLy); // Có thể là null
                    // 7. Lưu và Cập nhật trạng thái
                    danhSachDatPhong.add(dp);
                    khDat.themDatPhongVaoLichSu(dp);

                    p.CapNhatTrangThai("Đã đặt");
                    qlPhong.capNhatPhong(maPhong, p);

                    System.out.println("Đặt phòng thành công!");
                    break;
                case 7: // Xem lịch sử đặt phòng
                    System.out.print("Nhập mã khách hàng cần xem lịch sử: ");
                    KHACHHANG khLS = qlKH.timKiem(sc.nextLine());
                    if (khLS != null) khLS.xemLichSuDat();
                    else System.out.println("Không tìm thấy khách hàng!");
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void menuNhanVien(Scanner sc, QUANLYNHANVIEN qlNV) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Xóa nhân viên");
            System.out.println("3. Cập nhật nhân viên");
            System.out.println("4. Tìm nhân viên");
            System.out.println("5. Hiển thị tất cả nhân viên");
            System.out.println("6. Quay lại menu chính");
            System.out.print("Chọn: ");
            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số!");
                continue;
            }
            switch (chon) {
                case 1:
                    NHANVIEN nv = new NHANVIEN();
                    nv.Nhap();
                    qlNV.themNhanVien(nv);
                    break;
                case 2:
                    System.out.print("Nhập mã nhân viên cần xóa: ");
                    String maXoa = sc.nextLine();
                    qlNV.xoaNhanVien(maXoa);
                    break;
                case 3:
                    System.out.print("Nhập mã nhân viên cần cập nhật: ");
                    String maCapNhat = sc.nextLine();
                    NHANVIEN nvMoi = new NHANVIEN();
                    nvMoi.Nhap();
                    qlNV.capNhatNhanVien(maCapNhat, nvMoi);
                    break;
                case 4:
                    System.out.print("Nhập mã nhân viên cần tìm: ");
                    String maTim = sc.nextLine();
                    NHANVIEN nvTim = qlNV.timKiemNV(maTim);
                    if (nvTim != null)
                        nvTim.hienThiThongTin();
                    else
                        System.out.println("Không tìm thấy nhân viên!");
                    break;
                case 5:
                    qlNV.hienThiTatCa();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void menuHoaDon(Scanner sc, QUANLYHOADON qlHD, QUANLYKHACHHANG qlKH, QUANLYNHANVIEN qlNV, QUANLYPHONG qlPhong, List<DATPHONG> danhSachDatPhong) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ HÓA ĐƠN ---");
            System.out.println("1. Thêm hóa đơn (Lập từ Đặt phòng)");
            System.out.println("2. Xóa hóa đơn");
            System.out.println("3. Cập nhật hóa đơn");
            System.out.println("4. Tìm hóa đơn");
            System.out.println("5. Hiển thị tất cả hóa đơn");
            System.out.println("6. Thanh toán hóa đơn");
            System.out.println("7. Quay lại menu chính");
            System.out.print("Chọn: ");
            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số!");
                continue;
            }
            switch (chon) {
                case 1: // Thêm hóa đơn
                    System.out.print("Nhập mã đặt phòng cần lập hóa đơn: ");
                    String maDP = sc.nextLine();

                    DATPHONG dpCanLapHD = timKiemDatPhong(maDP, danhSachDatPhong);

                    if (dpCanLapHD == null) {
                        System.out.println("Lỗi: Không tìm thấy đơn đặt phòng với mã " + maDP);
                        break;
                    }
                    if (dpCanLapHD.getHd() != null) {
                        System.out.println("Lỗi: Đơn đặt phòng này đã có hóa đơn (Mã: " + dpCanLapHD.getHd().getMaHoaDon() + ")");
                        break;
                    }

                    // Kiểm tra nghiệp vụ để tránh lỗi: HOADON chỉ được lập khi đủ thông tin
                    if (dpCanLapHD.getP() == null || dpCanLapHD.getKh() == null) {
                        System.out.println("Lỗi: Đặt phòng thiếu thông tin Phòng hoặc Khách hàng. Không thể lập hóa đơn.");
                        break;
                    }

                    HOADON hd = new HOADON();
                    hd.setDp(dpCanLapHD); // GÁN DATPHONG TRƯỚC KHI NHẬP
                    hd.Nhap();
                    // Sau khi nhập xong, đảm bảo hóa đơn không bị trùng mã rồi thêm
                    if (qlHD.timKiemHoaDon(hd.getMaHoaDon()) == null) {
                        dpCanLapHD.setHd(hd); // Lưu lại hóa đơn vào đối tượng đặt phòng
                        qlHD.themHoaDon(hd);
                        System.out.println("Lập hóa đơn thành công!");
                    } else {
                        System.out.println("Lỗi: Mã hóa đơn vừa nhập đã tồn tại.");
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã hóa đơn cần xóa: ");
                    qlHD.xoaHoaDon(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhập mã hóa đơn cần cập nhật: ");
                    String maCapNhat = sc.nextLine();
                    // 1. Tìm hóa đơn cũ
                    HOADON hdCu = qlHD.timKiemHoaDon(maCapNhat);
                    if (hdCu == null) {
                        System.out.println("Lỗi: Không tìm thấy hóa đơn với mã " + maCapNhat + " để cập nhật.");
                        break;
                    }
                    // 2. Tạo hóa đơn mới và nhập thông tin (để ghi đè)
                    HOADON hdMoi = new HOADON();
                    hdMoi.Nhap();
                    hdMoi.setDp(hdCu.getDp());
                    qlHD.capNhatHoaDon(maCapNhat, hdMoi);
                    break;
                case 4:
                    System.out.print("Nhập mã hóa đơn cần tìm: ");
                    HOADON hdTim = qlHD.timKiemHoaDon(sc.nextLine());
                    if (hdTim != null)
                        hdTim.hienThiThongTin();
                    else
                        System.out.println("Không tìm thấy hóa đơn!");
                    break;
                case 5:
                    qlHD.hienThiTatCa();
                    break;
                case 6:
                    System.out.print("Nhập mã hóa đơn cần thanh toán: ");
                    HOADON hdTT = qlHD.timKiemHoaDon(sc.nextLine());
                    if (hdTT != null) hdTT.ThanhToan();
                    else System.out.println("Không tìm thấy hóa đơn!");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}