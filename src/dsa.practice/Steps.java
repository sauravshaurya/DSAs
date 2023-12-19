package dsa.practice;


public class Steps {


    public static int steps(int n) {
        return helper(n, 0);
    }

    public static int helper(int n, int steps) {

        if (n == 0) {
            return steps;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(steps(10200010));
    }
}


