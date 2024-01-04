import java.util.Scanner;



class FactorialCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Vui lòng nhập số nguyên dương.");
        } else {
            long result = calculateFactorial(n);
            System.out.println(n + "! = " + result);
        }

        scanner.close();
    }

    private static long calculateFactorial(int n) {
        // Base case: n! = 1 khi n = 0 hoặc n = 1
        if (n == 0 || n == 1) {
            return 1;
        } else {
            // Phương pháp chia để trị: n! = n * (n-1)!
            return (long) n * calculateFactorial(n - 1);
        }
    } // O(n^2)
}


// tính n! của bằng phương pháp chia để trị
