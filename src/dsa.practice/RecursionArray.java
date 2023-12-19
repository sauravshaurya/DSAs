package dsa.practice;

import java.util.ArrayList;
import java.util.List;

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
        if (index == arr.length - 1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return helperLinearSearch(arr, target, index + 1);
    }

    public static List<Integer> linearMultiSearch(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        return helperMultiLinearSearch(arr, target, 0, result);
    }

    public static List<Integer> helperMultiLinearSearch(int[] arr, int target, int index, List<Integer> result) {

        if (arr[index] == target) {
            result.add(index);
        }
        if (index == arr.length - 1) {
            return result;
        }
        return helperMultiLinearSearch(arr, target, index + 1, result);
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 2, 9};
        System.out.println("isSortedArray = " + isSortedArray(arr));
        System.out.println("linearSearch = " + linearSearch(arr, 91));
        System.out.println("linearMultiSearch = " + linearMultiSearch(arr, 9));
    }
}