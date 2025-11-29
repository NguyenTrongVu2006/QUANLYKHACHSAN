import java.util.ArrayList;

public class QUANLYNHANVIEN implements IQUANLYNHANVIEN {
    private ArrayList<NHANVIEN> danhSachNhanVien = new ArrayList<>();

    @Override
    public void themNhanVien(NHANVIEN nv) {
        if (timKiemNV(nv.getMaNV()) != null) {
            System.out.println("Lỗi: Mã nhân viên đã tồn tại. Không thể thêm.");
            return;
        }
        this.danhSachNhanVien.add(nv);
        System.out.println("Đã thêm nhân viên " + nv.getMaNV() + " thành công.");
    }

    @Override
    public void xoaNhanVien(String maNV) {
        NHANVIEN nvCanXoa = timKiemNV(maNV);
        if (nvCanXoa != null) {
            this.danhSachNhanVien.remove(nvCanXoa);
            System.out.println("Đã xóa nhân viên có mã " + maNV + " thành công.");
        } else {
            System.out.println("Lỗi: Không tìm thấy nhân viên với mã " + maNV);
        }
    }

    @Override
    public void capNhatNhanVien(String maNV, NHANVIEN nv) {
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            if (danhSachNhanVien.get(i).getMaNV().equals(maNV)) {
                danhSachNhanVien.set(i, nv);
                System.out.println("Đã cập nhật thông tin nhân viên mã " + maNV + " thành công.");
                return;
            }
        }
        System.out.println("Lỗi: Không tìm thấy nhân viên với mã " + maNV + " để cập nhật.");
    }

    @Override
    public NHANVIEN timKiemNV(String maNV) {
        for (NHANVIEN nv : danhSachNhanVien) {
            if (nv.getMaNV().equals(maNV))
                return nv;
        }
        return null;
    }

    @Override
    public void hienThiTatCa() {
        if (danhSachNhanVien.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH TẤT CẢ NHÂN VIÊN ---");
        for (NHANVIEN nv : danhSachNhanVien) {
            nv.hienThiThongTin();
        }
        System.out.println("-----------------------------------------");
    }
}