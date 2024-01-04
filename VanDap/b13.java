import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SubsequencesSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của dãy số: ");
        int n = scanner.nextInt();

        int[] sequence = new int[n];

        System.out.println("Nhập dãy số:");
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        System.out.print("Nhập số nguyên M: ");
        int targetSum = scanner.nextInt();

        List<List<Integer>> subsequences = findSubsequences(sequence, targetSum);

        System.out.println("Các dãy con có tổng bằng " + targetSum + " là:");
        for (List<Integer> subseq : subsequences) {
            System.out.println(subseq);
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, targetSum, 0, new ArrayList<>(), 0, result);
        return result;
    }

    private static void backtrack(int[] nums, int targetSum, int start, List<Integer> path, int currentSum, List<List<Integer>> result) {
        if (currentSum == targetSum) {
            result.add(new ArrayList<>(path));
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, targetSum, i + 1, path, currentSum + nums[i], result);
            path.remove(path.size() - 1);
        }
    }
}

/*
 * testcase: 
 * input: dãy 7 1 4 3 5 6 và M = 11
 * output: (7,1,3), (7,4), (1,4,6) và (5,6). 
 */




/*
 * 
 * Đề bài 13: Cho một dãy số nguyên dương (a0 ,a1 ,…,an-1 ) và một số nguyên
 * dương M. Ta cần tìm các dãy con của dãy sao cho tổng của các phần tử trong
 * dãy con đó bằng M. Chẳng hạn, với dãy số (7,1,4,3,5,6) và M=11, thì các dãy
 * con cần tìm là (7,1,3), (7,4), (1,4,6) và (5,6). Thiết kế TT giải bài toán
 * bằng phương pháp quay lui
 */