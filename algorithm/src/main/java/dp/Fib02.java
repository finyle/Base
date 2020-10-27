package dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Fib02 {

    public static int fib(int n) {
        if (n < 1) return 0;
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }
    private static int helper(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] =  helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
