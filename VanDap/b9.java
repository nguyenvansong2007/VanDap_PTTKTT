import java.util.Scanner;

class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng phần tử của dãy
        System.out.print("Nhập số lượng phần tử của dãy: ");
        int n = scanner.nextInt();

        // Nhập dãy số từ bàn phím
        int[] A = new int[n];
        System.out.println("Nhập dãy số:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            A[i] = scanner.nextInt();
        }

        // Gọi hàm sắp xếp QuickSort
        quicksort(A, 0, n - 1);

        // In dãy số đã sắp xếp
        System.out.println("Dãy số đã sắp xếp:");
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Gọi đệ quy sắp xếp 2 phần
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] và arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}


// độ phức tạp của thuật toán là O(n^2)