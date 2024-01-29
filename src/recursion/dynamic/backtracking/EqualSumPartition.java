package recursion.dynamic.backtracking;

import java.util.Arrays;

public class EqualSumPartition {

    static boolean equalSumPartition(int[] arr, int n, int W) {
        boolean[][] dp = new boolean[n + 1][W + 1];
        if (W % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    break;
                }
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3};
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);

        System.out.println("Equal sum partition possible? = " + equalSumPartition(arr, n, sum / 2));
    }
}
