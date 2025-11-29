import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KHACHHANG {
    private String maKH;
    private String tenKH;
    private String SDT;
    private String soCCCD;
    private String diaChi;
    private List<DATPHONG> lichSuDatPhong = new ArrayList<>();
    private Scanner sc= new Scanner(System.in);

    public KHACHHANG(){};
    public KHACHHANG(String maKH, String tenKH, String SDT, String soCCCD, String diaChi)
    {
        this.maKH =maKH;
        this.tenKH =tenKH;
        this.SDT =SDT;
        this.soCCCD =soCCCD;
        this.diaChi =diaChi;
        this.lichSuDatPhong = new ArrayList<>();
    }

    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH){
        this.maKH = maKH;
    }

    public List<DATPHONG> getLichSuDatPhong() {
        return lichSuDatPhong;
    }
    public void themDatPhongVaoLichSu(DATPHONG dp) {
        this.lichSuDatPhong.add(dp);
    }

    public void Nhap(){
        System.out.print("Nhập mã khách hàng: ");
        this.maKH = sc.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        this.tenKH = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.SDT=sc.nextLine();
        System.out.print("Nhập số CCCD: ");
        this.soCCCD=sc.nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.diaChi=sc.nextLine();
    }

    public void xemLichSuDat(){
        System.out.println("===============================");
        System.out.println("LỊCH SỬ ĐẶT PHÒNG CỦA KHÁCH HÀNG: " + this.maKH + ", " + this.tenKH);

        if (this.lichSuDatPhong.isEmpty()) {
            System.out.println(">>> Khách hàng chưa có lịch sử đặt phòng nào. <<<");
            return;
        }

        int stt = 1;
        for (DATPHONG dp : this.lichSuDatPhong) {
            System.out.println("\n--- Lần Đặt số " + stt + " ---");
            // 1. Hiển thị thông tin chính của ĐẶT PHÒNG
            dp.hienThiThongTin();
            // 2. Hiển thị thông tin PHÒNG đã đặt
            if (dp.getP() != null) {
                System.out.println("  > Mã Phòng: " + dp.getP().getMaPhong());
                System.out.println("  > Loại Phòng: " + dp.getP().getClass().getSimpleName());
                System.out.println("  > Số ngày thuê: " + dp.soNgayThue() + " ngày");
            } else {
                System.out.println("  > Thông tin Phòng: KHÔNG CÓ");
            }
            stt++;
        }
    }

    public void hienThiThongTin(){
        System.out.println("Mã khách hàng: "+this.maKH);
        System.out.println("Tên khách hàng: "+this.tenKH);
        System.out.println("SDT: "+this.SDT);
        System.out.println("CCCD: "+this.soCCCD);
        System.out.println("Địa chỉ: "+this.diaChi);
        System.out.println("--------------------");
    }
}
