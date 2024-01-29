package recursion.dynamic.backtracking;

public class SubsetSum {


    static boolean susbsetSumTopDown(int[] set, int n, int W) {
        boolean dp[][] = new boolean[n + 1][W + 1];

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
                if (set[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - set[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int W = 410;
        int n = set.length;
        System.out.println("Subset with given sum exists? = " + susbsetSumTopDown(set,n, W));
    }
}
