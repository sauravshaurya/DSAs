package dsa.practice;

public class RecursionArray {

    public static boolean isSortedArray(int[] arr) {
        int size = arr.length;
        return helperSortedArray(arr, 0);
    }

    public static boolean helperSortedArray(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }

        return arr[index] < arr[index + 1] && helperSortedArray(arr, index + 1);
    }

    public static int linearSearch(int[] arr, int target) {
        return helperLinearSearch(arr, target, 0);
    }

    public static int helperLinearSearch(int[] arr, int target, int index) {
        if(index == arr.length-1) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        }
        return helperLinearSearch(arr, target, index+1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 2};
        System.out.println("isSortedArray = " + isSortedArray(arr));
        System.out.println("linearSearch = " + linearSearch(arr, 91));
    }
}