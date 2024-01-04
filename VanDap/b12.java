import java.util.Scanner;

class KnapsackProblem {

    public static int knapsackValue(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng đồ vật (n): ");
        int n = scanner.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        System.out.println("Nhập giá trị và khối lượng của từng đồ vật:");
        for (int i = 0; i < n; i++) {
            System.out.print("Giá trị của đồ vật " + (i + 1) + ": ");
            val[i] = scanner.nextInt();
            System.out.print("Khối lượng của đồ vật " + (i + 1) + ": ");
            wt[i] = scanner.nextInt();
        }

        System.out.print("Nhập khối lượng tối đa của túi (W): ");
        int W = scanner.nextInt();

        int result = knapsackValue(W, wt, val, n);
        System.out.println("Giá trị lớn nhất có thể đạt được: " + result);
    }
}

/*
 * 
 * Đề bài 12: Có 1 chiếc túi có thể chứa được một khối lượng w, chúng ta có n
 * loại đồ vật được đánh số i,…, n. Mỗi đồ vật loại i (i = 1,…, n) có khối lượng
 * ai và có giá trị ci. Chúng ta muốn sắp xếp các đồ vật vào túi để nhận được
 * túi có giá trị lớn nhất có thể được. Hãy thiết kế thuật toán giải bài toán
 * cái túi theo phương pháp quy hoạch động.
 */

 