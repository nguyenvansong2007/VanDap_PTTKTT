import java.util.*;


class MatHang {
    int trongLuong;
    int giaTri;
    double tiLe;

    public MatHang(int trongLuong, int giaTri) {
        this.trongLuong = trongLuong;
        this.giaTri = giaTri;
        this.tiLe = (double) giaTri / trongLuong;
    }
}

class BaiToanCaiTui {
    public static void main(String[] args) {
        List<MatHang> matHangs = nhapDuLieuTuBanPhim();
        int trongLuongToiDa = nhapTrongLuongTuBanPhim();

        giaiBaiToanCaiTui(matHangs, trongLuongToiDa);
    }

    public static List<MatHang> nhapDuLieuTuBanPhim() {
        List<MatHang> matHangs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap thong tin cac mat hang:");
        System.out.println("TrongLuong GiaTri");

        for (int i = 0; i < 3; i++) {
            int trongLuong = scanner.nextInt();
            int giaTri = scanner.nextInt();

            matHangs.add(new MatHang(trongLuong, giaTri));
        }

        return matHangs;
    }

    public static int nhapTrongLuongTuBanPhim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap trong luong toi da cua tui: ");
        return scanner.nextInt();
    }

    public static void giaiBaiToanCaiTui(List<MatHang> matHangs, int trongLuongToiDa) {
        // Sắp xếp theo tỉ lệ giảm dần
        // Collections.sort(matHangs, Comparator.comparingDouble(MatHang::getTiLe).reversed());

        int trongLuongConLai = trongLuongToiDa;
        List<MatHang> matHangDaChon = new ArrayList<>();

        // Thực hiện tham lam
        for (MatHang matHang : matHangs) {
            if (trongLuongConLai >= matHang.trongLuong) {
                matHangDaChon.add(matHang);
                trongLuongConLai -= matHang.trongLuong;
            }
        }

        // In kết quả
        System.out.println("Cac mat hang duoc chon:");
        for (MatHang matHang : matHangDaChon) {
            System.out.println("Trong luong = " + matHang.trongLuong + ", Gia tri = " + matHang.giaTri);
        }

        System.out.println("Tong gia tri lon nhat co the dat duoc: " + tinhTongGiaTri(matHangDaChon));
    }

    public static int tinhTongGiaTri(List<MatHang> matHangs) {
        int tongGiaTri = 0;
        for (MatHang matHang : matHangs) {
            tongGiaTri += matHang.giaTri;
        }
        return tongGiaTri;
    }
}
