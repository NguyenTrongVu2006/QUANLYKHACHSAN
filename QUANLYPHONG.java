import java.util.ArrayList;

public class QUANLYPHONG implements IQUANLYPHONG {
    private ArrayList<PHONG> danhSachPhong = new ArrayList<>();

    @Override
    public void themPhong(PHONG phong) {
        if (timKiemPhong(phong.getMaPhong()) != null) {
            System.out.println(" Lỗi: Mã phòng đã tồn tại. Không thể thêm.");
            return;
        }
        this.danhSachPhong.add(phong);
        System.out.println(" Đã thêm phòng " + phong.getMaPhong() + " thành công.");
    }

    @Override
    public void xoaPhong(String maPhong) {
        PHONG phongCanXoa = timKiemPhong(maPhong);
        if (phongCanXoa != null) {
            this.danhSachPhong.remove(phongCanXoa);
            System.out.println(" Đã xóa phòng có mã " + maPhong + " thành công.");
        } else {
            System.out.println(" Lỗi: Không tìm thấy phòng với mã " + maPhong);
        }
    }

    @Override
    public void capNhatPhong(String maPhong, PHONG phongMoi) {
        for (int i = 0; i < danhSachPhong.size(); i++) {
            if (danhSachPhong.get(i).getMaPhong().equals(maPhong)) {
                danhSachPhong.set(i, phongMoi);
                System.out.println("Đã cập nhật thông tin phòng mã " + maPhong + " thành công.");
                return;
            }
        }
        System.out.println("Lỗi: Không tìm thấy phòng với mã " + maPhong + " để cập nhật.");
    }

    @Override
    public PHONG timKiemPhong(String maPhong) {
        for (PHONG phong : danhSachPhong) {
            if (phong.getMaPhong().equals(maPhong)) {
                return phong;
            }
        }
        return null;
    }

    @Override
    public void hienThiTatCa() {
        if (danhSachPhong.isEmpty()) {
            System.out.println("Danh sách phòng trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH TẤT CẢ PHÒNG ---");
        for (PHONG phong : danhSachPhong) {
            phong.hienThiThongTin();
            System.out.println("   -> Tổng giá tiền: " +  phong.tinhGiaTien());
        }
        System.out.println("-------------------------------------");
    }
}