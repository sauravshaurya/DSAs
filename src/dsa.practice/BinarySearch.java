package dsa.practice;

public class BinarySearch {

    public static int binarySearch(int[] arr, int low, int high, int target){

        while(low<high){

            int mid = low  + (high - low)/2;

            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,6,8,9,10,13,34};
        int low = 0;
        int high = arr.length-1;
        System.out.println(binarySearch(arr,low,high,6));

    }
}
