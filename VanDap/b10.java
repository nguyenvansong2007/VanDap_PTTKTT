import java.util.Scanner;


class MergeSort {

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

        // Gọi hàm sắp xếp MergeSort
        mergeSort(A, 0, n - 1);

        // In dãy số đã sắp xếp
        System.out.println("Dãy số đã sắp xếp:");
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Tìm điểm chia
            int mid = left + (right - left) / 2;

            // Gọi đệ quy trên nửa bên trái và bên phải
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Hợp nhất 2 nửa đã sắp xếp
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // Kích thước của 2 mảng con cần hợp nhất
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Tạo mảng tạm để lưu dữ liệu
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Sao chép dữ liệu vào mảng tạm
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Hợp nhất 2 mảng con
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Sao chép phần còn lại của mảng trái (nếu có)
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Sao chép phần còn lại của mảng phải (nếu có)
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
