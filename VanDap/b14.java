import java.util.Scanner;

class KnightTour {
    private static int[][] A;
    private static int[] X = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] Y = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static int dem = 0;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap n: ");
        n = scanner.nextInt();

        A = new int[n][n];

        System.out.print("Nhap vi tri ban dau.\nx: ");
        int a = scanner.nextInt();
        System.out.print("y: ");
        int b = scanner.nextInt();

        diChuyen(a, b);

        System.out.println("Khong tim thay duong di.");
        scanner.close();
    }

    private static void xuat() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(String.format("%2d ", A[i][j]));
            System.out.println();
        }
        System.out.println();
    }

    private static void diChuyen(int x, int y) {
        ++dem;
        A[x][y] = dem;

        for (int i = 0; i < 8; i++) {
            if (dem == n * n) {
                System.out.println("Cac buoc di la: ");
                xuat();
                System.exit(0);
            }

            int u = x + X[i];
            int v = y + Y[i];

            if (u >= 0 && u < n && v >= 0 && v < n && A[u][v] == 0)
                diChuyen(u, v);
        }

        --dem;
        A[x][y] = 0;
    }
}



/*
 * Đề bài 14: Cho 1 bàn cờ nxn, có n 2 . Một quân mã được di chuyển tuân theo
 * luật chơi cờ vua được đặt trên bàn cờ tại ô đầu tiên có tọa độ x0, y0. Cần
 * tìm 1 lộ trình gồm n2 – 1 bước sao cho nó phủ toàn bộ bàn cờ (mỗi ô được đi
 * qua đúng 1 lần). Thiết kế TT giải bài toán bằng phương pháp quay lui.
 */