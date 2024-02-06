package recursion.dynamic.backtracking;

public class SubsetCount {


    static int counSubset(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for(int i=0;i<n+1;i++) {
            for(int j=0;j<sum+1;j++) {
                if(i == 0) {
                    dp[i][j] = 1;
                }
                else if(j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 2;

        System.out.println("Total subset with given sum count = "+counSubset(arr, sum));


    }
}
