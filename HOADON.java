import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HOADON {
    private String maHoaDon;
    private Date ngayLap;
    private String trangThaiTT;
    private String phuongThucTT;
    private Scanner sc= new Scanner(System.in);
    private DATPHONG dp;

    public HOADON(){};
    public HOADON(String maHoaDon, Date ngayLap, String trangThaiTT, String phuongThucTT)
    {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.trangThaiTT = trangThaiTT;
        this.phuongThucTT = phuongThucTT;
    }

    public String getMaHoaDon(){
        return maHoaDon;
    }
    public void setMaHoaDon(String maHoaDon){
        this.maHoaDon = maHoaDon;
    }

    public DATPHONG getDp(){
        return dp;
    }
    public void setDp(DATPHONG dp){
        this.dp = dp;
    }

    public void Nhap(){
        try {
            System.out.println("Nhập mã hóa đơn: ");
            this.maHoaDon = sc.nextLine();
            System.out.println("Nhập ngày lập hóa đơn: ");
            SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            Date ngay = d.parse(this.sc.nextLine());
            this.ngayLap = ngay;
            System.out.println("Nhập trạng thái thanh toán: ");
            this.trangThaiTT = sc.nextLine();
            System.out.println("Nhập phương thức thanh toán: ");
            this.phuongThucTT = sc.nextLine();
        }
        catch (Exception ex){
            System.out.println("Ngày lập hóa đơn không hợp lệ!");
        }
    }

    public double tinhTongTien(){
        if (dp == null || dp.getP() == null) {
            System.out.println(" Không có thông tin đặt phòng để tính tiền.");
            return 0.0;
        }
        long soNgayThue = dp.soNgayThue();
        // Lấy đối tượng phòng đã đặt
        PHONG phong = dp.getP();
        return phong.tinhGiaTien() * soNgayThue - dp.getTienCoc();
    }

    public void ThanhToan() {
        this.trangThaiTT = "Đã thanh toán";
        System.out.println("Hóa đơn " + this.maHoaDon + " đã được thanh toán thành công.");
    }

    public void hienThiThongTin(){
        System.out.println("Mã hóa đơn: "+this.maHoaDon);
        if (dp == null) {
            System.out.println("Không có thông tin đặt phòng!");
            return;
        }
        else {
            if (dp.getKh() != null) {
                System.out.println("Mã khách hàng: " + dp.getKh().getMaKH());
            }
            if (dp.getNv() != null)
                System.out.println("Mã nhân viên: " + dp.getNv().getMaNV());
        }
        System.out.println("Ngày lập: "+this.ngayLap);
        System.out.println("Trạng thái thanh Toán: "+this.trangThaiTT);
        System.out.println("Phương thức thanh toán: "+this.phuongThucTT);
        System.out.println("Tổng tiền thanh toán (sau khi trừ cọc): " + tinhTongTien());
    }
}
