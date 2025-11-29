import java.util.ArrayList;
import java.util.Scanner;

public class QUANLYKHACHHANG implements IQUANLYKHACHHANG{
    private ArrayList<KHACHHANG> danhSachKH = new ArrayList<>();

    @Override
    public void themKhachHang(KHACHHANG kh) {
        if (timKiem(kh.getMaKH()) != null) {
            System.out.println("Lỗi: Mã khách hàng đã tồn tại. Không thể thêm.");
            return;
        }
        this.danhSachKH.add(kh);
        System.out.println("Đã thêm khách hàng " + kh.getMaKH() + " thành công.");
    }

    @Override
    public void xoaKhachHang(String maKH) {
        KHACHHANG khachHangCanXoa = timKiem(maKH);
        if (khachHangCanXoa != null) {
            this.danhSachKH.remove(khachHangCanXoa);
            System.out.println("Đã xóa khách hàng có mã " + maKH + " thành công.");
        } else {
            System.out.println("Lỗi: Không tìm thấy khách hàng với mã " + maKH + ".");
        }
    }

    @Override
    public void capNhatKhachHang(String maKH, KHACHHANG kh) {
        for (int i = 0; i < danhSachKH.size(); i++) {
            if (danhSachKH.get(i).getMaKH().equals(maKH)) {
                danhSachKH.set(i, kh);
                System.out.println("Đã cập nhật thông tin khách hàng mã " + maKH + " thành công.");
                return;
            }
        }
        System.out.println("Lỗi: Không tìm thấy khách hàng với mã " + maKH + " để cập nhật.");
    }

    @Override
    public KHACHHANG timKiem(String maKH) {
        for (KHACHHANG kh : danhSachKH) {
            if (kh.getMaKH().equals(maKH)) {
                return kh;
            }
        }
        return null;
    }

    @Override
    public void hienThiTatCa() {
        if (danhSachKH.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH TẤT CẢ KHÁCH HÀNG ---");
        for (KHACHHANG kh : danhSachKH) {
            kh.hienThiThongTin();
        }
        System.out.println("-----------------------------------------");
    }
}