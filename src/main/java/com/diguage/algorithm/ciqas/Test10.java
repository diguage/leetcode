package com.diguage.algorithm.ciqas;

/**
 * {@link com.diguage.algorithm.leetcode._0070_ClimbingStairs}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 21:29
 */
public class Test10 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int i1 = 0;
        int i2 = 1;
        for (int i = 2; i <= n; i++) {
            if (i1 <= i2) {
                i1 += i2;
            } else {
                i2 += i1;
            }
        }
        return Math.max(i1, i2);
    }

    public int numWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 3) {
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            if (i1 <= i2) {
                i1 += i2;
            } else {
                i2 += i1;
            }
            if (Math.max(i1, i2) > 1000000007) {
                int small = Math.min(Math.min(i1, i2), Math.max(i1, i2) % 1000000007);
                int big = Math.max(Math.min(i1, i2), Math.max(i1, i2) % 1000000007);
                i1 = small;
                i2 = big;
            }
        }
        return Math.max(i1, i2);
    }


    public static void main(String[] args) {
        Test10 solution = new Test10();
        System.out.println(solution.fib(45));
        System.out.println(1134903170 > Integer.MAX_VALUE);

        System.out.println(solution.numWays(7));

    }
}
