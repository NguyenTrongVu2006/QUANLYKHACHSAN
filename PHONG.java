import java.util.Scanner;

public abstract class PHONG {
    protected String maPhong;
    protected String loaiPhong;
    protected double giaCoBan;
    protected String trangThai;
    protected Scanner sc= new Scanner(System.in);

    public PHONG(){};
    public PHONG(String maPhong, String loaiPhong, double giaCoBan, String trangThai)
    {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.giaCoBan = giaCoBan;
        this.trangThai = trangThai;
    }

    public String getMaPhong(){
        return maPhong;
    }
    public void setMaPhong(String maPhong){
        this.maPhong = maPhong;
    }

    public String getTrangThai(){
        return trangThai;
    }
    public void setTrangThai(){
        this.trangThai = trangThai;
    }

    public void Nhap(){
        System.out.print("Nhập mã phòng: ");
        this.maPhong = sc.nextLine();
        System.out.print("Nhập loại phòng: ");
        this.loaiPhong = sc.nextLine();
        System.out.print("nhập giá cơ bản: ");
        this.giaCoBan = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập trạng thái: ");
        this.trangThai = sc.nextLine();
    }

    public void CapNhatTrangThai(String trangThai){
        this.trangThai = trangThai;
    }

    public void hienThiThongTin(){
        System.out.println("Mã phòng là: " +maPhong);
        System.out.println("Loại Phòng: " +loaiPhong);
        System.out.println("Giá cơ bản: " +giaCoBan);
        System.out.println("Trạng Thái: " +trangThai);
    }

    public abstract double tinhGiaTien();
}
