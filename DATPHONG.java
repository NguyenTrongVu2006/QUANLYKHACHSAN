import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DATPHONG {
    private String maDatPhong;
    private Date ngayDen;
    private Date ngayDi;
    private double tienCoc;
    private PHONG p;
    private KHACHHANG kh;
    private NHANVIEN nv;
    private HOADON hd;
    private Scanner sc = new Scanner(System.in);

    public DATPHONG(){};
    public DATPHONG(String maDatPhong, Date ngayDen, Date ngayDi, double tienCoc)
    {
        this.maDatPhong = maDatPhong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.tienCoc = tienCoc;
    }

    public String getMaDatPhong(){
        return maDatPhong;
    }
    public void setMaDatPhong(String maDatPhong){
        this.maDatPhong = maDatPhong;
    }

    public PHONG getP(){
        return p;
    }
    public void setP(PHONG p){
        this.p = p;
    }

    public Double getTienCoc(){
        return tienCoc;
    }
    public void setTienCoc(Double tienCoc){
        this.tienCoc = tienCoc;
    }

    public KHACHHANG getKh(){
        return kh;
    }
    public void setKh(KHACHHANG kh){
        this.kh =kh;
    }

    public NHANVIEN getNv(){
        return nv;
    }
    public void setNv(NHANVIEN nv){
        this.nv = nv;
    }

    public HOADON getHd() {
        return hd;
    }
    public void setHd(HOADON hd) {
        this.hd = hd;
    }

    public void Nhap(){
        while (true) {
            try {
                System.out.print("Nhập mã đặt phòng: ");
                this.maDatPhong = sc.nextLine();
                SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
                System.out.print("Nhập ngày đến (dd/MM/yyyy): ");
                Date den = d.parse(sc.nextLine());
                System.out.print("Nhập ngày đi (dd/MM/yyyy): ");
                Date di = d.parse(sc.nextLine());
                if (di.before(den)) {
                    System.out.println("Ngày đi phải lớn hơn hoặc bằng ngày đến!");
                    continue;
                }
                this.ngayDen = den;
                this.ngayDi = di;
                System.out.print("Tiền cọc: ");
                this.tienCoc = Double.parseDouble(sc.nextLine());
                break;
            } catch (ParseException ex) {
                System.out.println("LỖI NHẬP LIỆU: Định dạng ngày tháng không đúng (phải là dd/MM/yyyy)!");
            }
        }
    }

    public long soNgayThue() {
        if (ngayDen == null || ngayDi == null)
            return 0;
        long millis = ngayDi.getTime() - ngayDen.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(millis);
        if (days <= 0)
            return 1;   // Tính tối thiểu 1 ngày
        return days;
    }

    public void hienThiThongTin(){
        System.out.println("===== THÔNG TIN ĐẶT PHÒNG =====");
        System.out.println("Mã đặt phòng: " + this.maDatPhong);
        System.out.println("Ngày đến: " + this.ngayDen);
        System.out.println("Ngày đi: " + this.ngayDi);
        System.out.println("Tiền cọc: " + this.tienCoc);
    }
}
