package dsa.practice;


public class CountZeros {


    public static int count(int n) {
        return helper(n, 0);
    }

    public static int helper(int n, int count) {

        if (n == 0) {
            return count;
        }
        if (n % 10 == 0) {
            return helper(n / 10, count + 1);
        }
        return helper(n / 10, count);
    }

    public static void main(String[] args) {
        System.out.println(count(10200010));
    }
}


