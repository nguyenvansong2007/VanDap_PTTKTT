class NQueens {

    public static void printSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Kiểm tra cột
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Kiểm tra đường chéo chính
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Kiểm tra đường chéo phụ
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueensUtil(int[][] board, int row, int n) {
        if (row == n) {
            printSolution(board);
            return true;
        }

        boolean result = false;
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                result = solveNQueensUtil(board, row + 1, n) || result;

                board[row][col] = 0; // Quay lui
            }
        }

        return result;
    }

    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        if (!solveNQueensUtil(board, 0, n)) {
            System.out.println("Không có lời giải.");
        }
    }

    public static void main(String[] args) {
        solveNQueens(8);
    }
}
