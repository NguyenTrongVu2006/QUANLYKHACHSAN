import java.util.ArrayList;

public class QUANLYHOADON implements IQUANLYHOADON {
    private ArrayList<HOADON> danhSachHoaDon = new ArrayList<>();

    @Override
    public void themHoaDon(HOADON hd) {
        // Kiểm tra trùng mã hóa đơn trước khi thêm
        if (timKiemHoaDon(hd.getMaHoaDon()) != null) {
            System.out.println(" Lỗi: Mã hóa đơn đã tồn tại. Không thể thêm.");
            return;
        }
        this.danhSachHoaDon.add(hd);
        System.out.println(" Đã thêm hóa đơn " + hd.getMaHoaDon() + " thành công.");
    }

    @Override
    public void xoaHoaDon(String maHoaDon) {
        HOADON hoaDonCanXoa = timKiemHoaDon(maHoaDon);
        if (hoaDonCanXoa != null) {
            this.danhSachHoaDon.remove(hoaDonCanXoa);
            System.out.println(" Đã xóa hóa đơn có mã " + maHoaDon + " thành công.");
        } else {
            System.out.println(" Lỗi: Không tìm thấy hóa đơn với mã " + maHoaDon + ".");
        }
    }

    @Override
    public void capNhatHoaDon(String maHoaDon,HOADON hd) {
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            if (danhSachHoaDon.get(i).getMaHoaDon().equals(hd.getMaHoaDon())) {
                danhSachHoaDon.set(i, hd);
                System.out.println("Đã cập nhật thông tin hóa đơn mã " + maHoaDon + " thành công.");
                return;
            }
        }
        System.out.println(" Lỗi: Không tìm thấy hóa đơn với mã " + maHoaDon + " để cập nhật.");
    }

    @Override
    public HOADON timKiemHoaDon(String maHoaDon) {
        for (HOADON hd : danhSachHoaDon) {
            if (hd.getMaHoaDon().equals(maHoaDon)) {
                return hd;
            }
        }
        return null;
    }

    @Override
    public void hienThiTatCa() {
        if (danhSachHoaDon.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH TẤT CẢ HÓA ĐƠN ---");
        for (HOADON hd : danhSachHoaDon) {
            hd.hienThiThongTin();
        }
        System.out.println("--------------------------------");
    }
}