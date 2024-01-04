import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class PartitionList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số tự nhiên n (n <= 100): ");
        int n = scanner.nextInt();

        if (n <= 100) {
            List<List<Integer>> partitions = getPartitions(n);
            displayPartitions(partitions);
        } else {
            System.out.println("Vui lòng nhập n nhỏ hơn hoặc bằng 100.");
        }

        scanner.close();
    }

    static List<List<Integer>> getPartitions(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPartition = new ArrayList<>();
        countPartitions(n, result, currentPartition, 1);
        return result;
    }

    static void countPartitions(int n, List<List<Integer>> result, List<Integer> currentPartition, int start) {
        if (n == 0) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = start; i <= n; i++) {
            currentPartition.add(i);
            countPartitions(n - i, result, currentPartition, i);
            currentPartition.remove(currentPartition.size() - 1);
        }
    }

    static void displayPartitions(List<List<Integer>> partitions) {
        System.out.println("Các cách phân tích số:");
        for (List<Integer> partition : partitions) {
            System.out.println(partition);
        }
    }
}


// giống đề số 5