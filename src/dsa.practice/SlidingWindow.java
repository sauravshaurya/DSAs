package dsa.practice;

public class SlidingWindow {

    static int maxSum(int[] arr, int n, int k) {

        if (n < k) {
            return -1;
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum = maxSum + arr[i];
        }

        int win_sum = maxSum;
        for (int j = k; j < n; j++) {
            win_sum = win_sum + arr[j] - arr[j-k];
            maxSum = Math.max(maxSum, win_sum);
        }

        return  maxSum;


    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int n = arr.length;
        int k = 4;
        System.out.println(maxSum(arr,n,k));
    }
}
