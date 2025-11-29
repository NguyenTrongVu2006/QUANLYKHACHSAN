public class PHONGDON extends  PHONG{
    private boolean giuongDon;

    public PHONGDON(){
        super();
    };
    public PHONGDON(String maPhong, String loaiPhong, double giaCoBan, String trangThai, boolean giuongDon)
    {
        super(maPhong, loaiPhong, giaCoBan, trangThai);
        this.giuongDon = giuongDon;
    }

    @Override
    public void Nhap(){
        super.Nhap();
        System.out.print("Có phải là giường đơn: ");
        this.giuongDon = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("Giường đơn: "+this.giuongDon);
    }

    @Override
    public double tinhGiaTien(){
        if (this.giuongDon)
            return 100000 + this.giaCoBan;
        else
            return 200000 + this.giaCoBan;
    }
}
