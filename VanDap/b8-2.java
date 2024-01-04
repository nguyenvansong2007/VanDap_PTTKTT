import java.util.Scanner;

class FactorialCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Vui lòng nhập số nguyên dương.");
        } else {
            long result = dynamicProgrammingFactorial(n);
            System.out.println(n + "! = " + result);
        }

        scanner.close();
    }

    private static long dynamicProgrammingFactorial(int n) {
        if (n < 0) {
            return -1; // Trường hợp không hợp lệ
        }

        // Tạo mảng để lưu trữ kết quả các giai thừa từ 0 đến n
        long[] factorialArray = new long[n + 1];

        // Base case: 0! và 1! đều bằng 1
        factorialArray[0] = 1;
        factorialArray[1] = 1;

        // Tính toán và lưu trữ các giá trị giai thừa trong mảng
        for (int i = 2; i <= n; i++) {
            factorialArray[i] = i * factorialArray[i - 1];
        } // O(n)

        // Kết quả là giá trị của n! ở phần tử cuối cùng của mảng
        return factorialArray[n];
    }
}


// tính n! bằng phương pháp quy hoạch động