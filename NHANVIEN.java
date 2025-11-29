import java.util.Scanner;

public class NHANVIEN{
    private String maNV;
    private String tenNV;
    private String chucVu;
    private double luongCoBan;
    private double heSoLuong;
    private Scanner sc = new Scanner(System.in);

    public NHANVIEN(){};

    public NHANVIEN(String maNV, String tenNV, String chucVu, double luongCoBan, double heSoLuong)
    {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void Nhap(){
        System.out.print("Nhập mã nhân viên: ");
        this.maNV = sc.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        this.tenNV = sc.nextLine();
        System.out.print("Chức vụ: ");
        this.chucVu = sc.nextLine();
        System.out.print("Lương cơ bản: ");
        this.luongCoBan = Double.parseDouble(sc.nextLine());
        System.out.print("Hệ số lương: ");
        this.heSoLuong = Double.parseDouble(sc.nextLine());
    }

    public double tinhLuong(){
            return this.luongCoBan*this.heSoLuong;
    }

    public void hienThiThongTin(){
        System.out.println("Mã nhân viên: "+this.maNV);
        System.out.println("Tên nhân viên: "+this.tenNV);
        System.out.println("Chức vụ: "+this.chucVu);
        System.out.println("Lương cơ bản: "+this.luongCoBan);
        System.out.println("Hệ số lương: "+this.heSoLuong);
        System.out.println("    -> Tổng lương: "+tinhLuong());
    }
}
