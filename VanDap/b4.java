import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class AllLongestCommonSubsequences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập độ dài của dãy số thứ nhất: ");
        int m = scanner.nextInt();
        int[] X = new int[m];
        System.out.println("Nhập các phần tử của dãy số thứ nhất:");
        for (int i = 0; i < m; i++) {
            X[i] = scanner.nextInt();
        }

        System.out.print("Nhập độ dài của dãy số thứ hai: ");
        int n = scanner.nextInt();
        int[] Y = new int[n];
        System.out.println("Nhập các phần tử của dãy số thứ hai:");
        for (int i = 0; i < n; i++) {
            Y[i] = scanner.nextInt();
        }

        ArrayList<int[]> result = allLongestCommonSubsequences(X, Y);

        System.out.println("Các dãy con chung dài nhất:");
        for (int[] sequence : result) {
            System.out.println(Arrays.toString(sequence));
        }
    }

    public static ArrayList<int[]> allLongestCommonSubsequences(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        // Tạo bảng để lưu trữ độ dài của dãy con chung
        int[][] dp = new int[m + 1][n + 1];

        // Xây dựng bảng dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Dãy con chung dài nhất nằm ở dp[m][n]
        int lcsLength = dp[m][n];

        // Xây dựng tất cả các dãy con chung dài nhất
        ArrayList<int[]> allLCS = new ArrayList<>();
        generateAllLCS(X, Y, m, n, dp, new int[lcsLength], lcsLength, allLCS);

        return allLCS;
    }

    public static void generateAllLCS(int[] X, int[] Y, int m, int n, int[][] dp, int[] currentLCS,
            int currentIndex, ArrayList<int[]> allLCS) {
        if (m == 0 || n == 0) {
            int[] newLCS = Arrays.copyOfRange(currentLCS, currentIndex, currentLCS.length);
            allLCS.add(newLCS);
            return;
        }

        if (X[m - 1] == Y[n - 1]) {
            currentLCS[currentIndex - 1] = X[m - 1];
            generateAllLCS(X, Y, m - 1, n - 1, dp, currentLCS, currentIndex - 1, allLCS);
        } else if (dp[m - 1][n] > dp[m][n - 1]) {
            generateAllLCS(X, Y, m - 1, n, dp, currentLCS, currentIndex, allLCS);
        } else if (dp[m][n - 1] > dp[m - 1][n]) {
            generateAllLCS(X, Y, m, n - 1, dp, currentLCS, currentIndex, allLCS);
        } else {
            generateAllLCS(X, Y, m - 1, n, dp, Arrays.copyOf(currentLCS, currentLCS.length), currentIndex, allLCS);
            generateAllLCS(X, Y, m, n - 1, dp, Arrays.copyOf(currentLCS, currentLCS.length), currentIndex, allLCS);
        }
    }
}

/*
 * Bài số 4: Thiết kế thuật toán Tìm dãy con chung của hai dãy số bằng phương
 * pháp quy hoạch động.
 * Xét bài toán sau: Cho hai dãy số nguyên a = (a1,…, am) và b = (b1,…bn), ta
 * cần tìm dãy số nguyên c = (c1,…, ck) sao cho c là dãy con của cả a và b, và c
 * là dài nhất có thể được. Ví dụ, nếu a = (3, 5, 1, 3, 5, 5, 3) và b =
 * (1,5,3,5,3,1) thì dãy con chung dài nhất là c = (5,3,5,3) hoặc c = (1,3,5,3)
 * hoặc c = (1,5,5,3).
 * 3 5 1 3 5 5 3
 * 1 5 3 5 3 1
 * 
 * 
 */

/*
 * 1. Mô tả chi tiết thuật toán
 * Tạo Bảng DP:
 * 
 * Tạo một bảng dp với kích thước (m + 1) x (n + 1), trong đó m là độ dài của
 * dãy X và n là độ dài của dãy Y.
 * Bảng dp[i][j] sẽ lưu độ dài của dãy con chung dài nhất của dãy X[0...i-1] và
 * Y[0...j-1].
 * Xây Dựng Bảng DP:
 * 
 * Sử dụng hai vòng lặp lồng nhau để điền các giá trị vào bảng dp.
 * Nếu X[i - 1] == Y[j - 1], thì dp[i][j] = dp[i - 1][j - 1] + 1.
 * Nếu X[i - 1] != Y[j - 1], thì dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]).
 * Lấy Độ Dài Dãy Con Chung Dài Nhất:
 * 
 * Độ dài của dãy con chung dài nhất nằm ở dp[m][n].
 * Xây Dựng Tất Cả Các Dãy Con Chung Dài Nhất:
 * 
 * Sử dụng một mảng động currentLCS để xây dựng từng dãy con chung dài nhất.
 * Sử dụng hàm đệ quy generateAllLCS để thực hiện việc xây dựng tất cả các dãy
 * con chung dài nhất.
 * Hàm này sẽ thử từng trường hợp: chọn phần tử từ X, chọn phần tử từ Y, hoặc cả
 * hai.
 * Khi quay lui, đồng thời giảm kích thước của m hoặc n dựa trên giá trị của
 * bảng dp.
 * 
 */