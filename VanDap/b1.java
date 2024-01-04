import java.util.Arrays; // Sử dụng để sắp xếp mảng mệnh giá.
import java.util.HashMap; // Dùng để lưu trữ số tờ của từng mệnh giá.
import java.util.Map; //  Interface đại diện cho một bảng ánh xạ (key-value pairs).
import java.util.Scanner; //  Để đọc dữ liệu từ người dùng.

class DoiTien {

    public static Map<Double, Integer> doiTien(double amount, double[] denominations) {
        /*
         * Hàm này nhận vào số tiền cần đổi (amount) và một mảng mệnh giá
         * (denominations), và trả về một Map chứa số tờ của từng mệnh giá.
         */
        Map<Double, Integer> result = new HashMap<>();
        Arrays.sort(denominations); // Sắp xếp mảng mệnh giá theo thứ tự tăng dần.
        int index = denominations.length - 1; // Bắt đầu duyệt từ mệnh giá lớn nhất.

        /*
         * Duyệt qua mảng mệnh giá từ lớn đến nhỏ.
         * Nếu số tiền còn lại lớn hơn hoặc bằng mệnh giá, tính số tờ có thể đổi và cập
         * nhật Map.
         * Giảm giá trị của amount sau mỗi lần đổi.
         */
        while (amount > 0 && index >= 0) {
            double denomination = denominations[index];
            if (amount >= denomination) {
                int numNotes = (int) (amount / denomination);
                result.put(denomination, numNotes);
                amount -= numNotes * denomination;
            }
            index--; // Trả về Map chứa số tờ của từng mệnh giá.

        }

        return result;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Nhap so tien can doi: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("So tien phai lon hon 0.");
                return;
            }

            System.out.print("Nhap so luong cac menh gia: ");
            int numDenominations = sc.nextInt();

            double[] denominations = new double[numDenominations];
            System.out.print("Nhap cac menh gia cach nhau boi dau cach: ");
            for (int i = 0; i < numDenominations; i++) {
                denominations[i] = sc.nextDouble();

                if (denominations[i] <= 0) {
                    System.out.println("Menh gia phai lon hon 0.");
                    return;
                }
            }

            Map<Double, Integer> result = doiTien(amount, denominations);

            System.out.println("\nKet qua:");
            for (Map.Entry<Double, Integer> entry : result.entrySet()) {
                System.out.printf("Menh gia %.2f: %d to\n", entry.getKey(), entry.getValue());
            }

        } catch (Exception e) {
            System.out.println("Nhap khong hop le. Vui long nhap so nguyen hoac so thap phan.");
        }
    }
}

/*
 * Đề bài 1: Xét bài toán đổi tiền xu cho một số tiền có giá trị bằng n xu ( n
 * nhập từ bàn phím) sao cho số đồng xu đổi ra là nhỏ nhất. Thiết kế một giải
 * thuật tham lam để đổi tiền có dùng các đồng xu sau: 5000, 2000, 1000, 500.
 * 
 * 1. mô tả chi tiết bài toán: khi nhập các số liệu từ bàn phím ta thực hiện
 * thao tác sắp xếp các mệnh giá tiền theo chiều giảm dần. Sau đó thực hiện thao tác chia số tiền 
 * 
 * 
 * 
 */