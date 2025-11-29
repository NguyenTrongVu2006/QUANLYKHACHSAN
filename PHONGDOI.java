public class PHONGDOI extends PHONG{
    private int soNguoi;

    public PHONGDOI(){
        super();
    }

    public PHONGDOI(String maPhong, String loaiPhong, double giaCoBan, String trangThai, int soNguoi)
    {
        super(maPhong, loaiPhong, giaCoBan, trangThai);
        this.soNguoi = soNguoi;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        System.out.print("Nhập số người: ");
        this.soNguoi = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("Số người : "+this.soNguoi);
    }

    @Override
    public double tinhGiaTien(){
        return this.giaCoBan*this.soNguoi + 500000;
    }
}
