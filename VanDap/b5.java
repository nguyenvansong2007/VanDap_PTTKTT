import java.util.ArrayList;
import java.util.Scanner;

class PartitionListing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị n: ");
        int n = scanner.nextInt();

        ArrayList<ArrayList<Integer>> partitions = listPartitions(n);

        System.out.println("Các dãy số phân tích thành " + n + " là:");
        for (ArrayList<Integer> partition : partitions) {
            System.out.println(partition);
        }

        scanner.close();
    }

    static ArrayList<ArrayList<Integer>> listPartitions(int n, int max) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (n == 0) {
            // Trường hợp cơ bản: số cách phân tích số 0 là 1 (không phân tích).
            result.add(new ArrayList<>());
            return result;
        }

        for (int i = 1; i <= Math.min(max, n); i++) {
            ArrayList<ArrayList<Integer>> subPartitions = listPartitions(n - i, i);

            for (ArrayList<Integer> subPartition : subPartitions) {
                subPartition.add(i);
                result.add(subPartition);
            }
        }

        return result;
    }

    static ArrayList<ArrayList<Integer>> listPartitions(int n) {
        return listPartitions(n, n);
    }
}


// độ phức tạp của thuật toán là O(n^2)