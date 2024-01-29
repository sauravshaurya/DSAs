package recursion.dynamic.backtracking;

public class KnapsackZeroOne {

    static int recursiveKnap(int W, int[] wt, int[] val, int n) {

        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {
            return Math.max((val[n - 1] + recursiveKnap(W - wt[n - 1], wt, val, n - 1)),
                    recursiveKnap(W, wt, val, n - 1));
        } else
            return recursiveKnap(W, wt, val, n - 1);
    }

    static int memoizedKnap(int W, int[] wt, int[] val, int n, int[][] dp) {

        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max((val[n - 1] + memoizedKnap(W - wt[n - 1], wt, val, n - 1, dp)),
                    memoizedKnap(W, wt, val, n - 1, dp));
            return dp[n][W];
        } else if (wt[n - 1] > W) {
            dp[n][W] = memoizedKnap(W, wt, val, n - 1, dp);
            return dp[n][W];
        }

        return dp[n][W];
    }

    static int topDownKnap(int W, int[] wt, int[] val, int n, int[][] dp) {

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = -1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                if (wt[i - 1] <= W) {
                    dp[i][j] = Math.max((val[i - 1] + dp[n - 1][W - wt[i - 1]]),
                            dp[n - 1][W]);
                } else {
                    dp[i][j] = dp[n - 1][W];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {4, 5, 1};
        int[] val = {1, 2, 3};
        int W = 4;
        int n = wt.length;

        System.out.println("Res by recursion = " + recursiveKnap(W, wt, val, n));

        int dp[][] = new int[n + 1][W + 1];

        System.out.println("Res by topDown = " + topDownKnap(W, wt, val, n, dp));

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Res by memoizedKnap = " + memoizedKnap(W, wt, val, n, dp));

    }

}
