import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class CongViec {
    String tenCongViec;
    int batDau;
    int ketThuc;

    public CongViec(String tenCongViec, int batDau, int ketThuc) {
        this.tenCongViec = tenCongViec;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
    }
}

class SapXepLichLamViec {

    public static void sapXepLich(List<CongViec> congViecList) {
        Collections.sort(congViecList, Comparator.comparingInt(c -> c.ketThuc)); // O(nlog n)

        System.out.println("Lich lam viec sau khi sap xep:");
        for (CongViec cv : congViecList) { // O(n)
            System.out.println(cv.tenCongViec + " - Bat dau: " + cv.batDau + " - Ket thuc: " + cv.ketThuc);
        }

        List<CongViec> lichLamViec = new ArrayList<>();
        lichLamViec.add(congViecList.get(0));

        int ketThucTruocNhat = congViecList.get(0).ketThuc;

        for (int i = 1; i < congViecList.size(); i++) {
            CongViec cv = congViecList.get(i);
            if (cv.batDau >= ketThucTruocNhat) {
                lichLamViec.add(cv);
                ketThucTruocNhat = cv.ketThuc;
            }
        }

        System.out.println("\nLich lam viec sau khi sap xep va chon cong viec:");
        for (CongViec cv : lichLamViec) {
            System.out.println(cv.tenCongViec + " - Bat dau: " + cv.batDau + " - Ket thuc: " + cv.ketThuc);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CongViec> congViecList = new ArrayList<>();

        System.out.print("Nhap so luong cong viec: ");
        int soLuongCongViec = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống

        for (int i = 0; i < soLuongCongViec; i++) {
            System.out.println("\nNhap thong tin cho cong viec thu " + (i + 1));
            System.out.print("Nhap ten cong viec: ");
            String tenCongViec = scanner.nextLine();

            System.out.print("Nhap thoi gian bat dau: ");
            int batDau = scanner.nextInt();

            System.out.print("Nhap thoi gian ket thuc: ");
            int ketThuc = scanner.nextInt();

            scanner.nextLine(); // Đọc dòng trống

            congViecList.add(new CongViec(tenCongViec, batDau, ketThuc));
        }

        sapXepLich(congViecList);
    }
}


// độ phức tạp của thuật toán này này 0(n)

/*
 * 
 * Đề bài 3: Cho 9 hoạt động với thời điểm bắt đầu và thời điểm kết thúc của
 * chúng như sau:
 * i 1 2 3 4 5 6 7 8 9
 * Si 1 3 4 2 6 4 10 12 11
 * Fi 3 4 6 8 10 13 14 15 16
 * Hãy áp dụng giải thuật tham lam để giải bài toán xếp lịch của các hoạt động
 * trên
 * 
 * 1. Mô tả chi tiết thuật toán
 * a. sắp xếp công việc theo thời gian kết thúc tăng dần: Bước này sử dụng
 * Collections.sort để sắp xếp danh sách công việc dựa trên thời gian kết thúc
 * của mỗi công việc.
 * b. Chọn công việc: Khởi tạo một danh sách lichLamViec để lưu trữ các công
 * việc
 * đã chọn. Chọn công việc đầu tiên từ danh sách đã sắp xếp và thêm vào
 * lichLamViec. Thiết lập biến ketThucTruocNhat bằng thời gian kết thúc của công
 * việc đầu tiên.
 * c. Lặp qua danh sách các công việc còn lại: Bắt đầu từ công việc thứ hai,
 * kiểm
 * tra xem thời gian bắt đầu của công việc có lớn hơn hoặc bằng ketThucTruocNhat
 * hay không. Nếu có, thêm công việc đó vào danh sách lichLamViec và cập nhật
 * ketThucTruocNhat thành thời gian kết thúc của công việc vừa chọn.
 * d. In lịch làm việc cuối cùng: In ra màn hình danh sách công việc đã sắp xếp
 * và được chọn để tạo lịch làm việc.
 



 */