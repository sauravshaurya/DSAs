package dsa.practice.sliding.window;

public class SlidingWindow {
//max sum in a window of k elements
    static int maxSum(int[] arr, int n, int k) {

        if(n<k){
            return -1;
        }

        int maxSum = 0;
        for(int i=0;i<k;i++) {
            maxSum = maxSum + arr[i];
        }
        int winSum = maxSum;

        for(int j=k;j<n;j++) {
            winSum = winSum + arr[j] - arr[j-k];
            maxSum = Math.max(maxSum, winSum);
        }

return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int n = arr.length;
        int k = 2;
        System.out.println(maxSum(arr,n,k));
    }
}
