package com.diguage.algo.leetcode;

/**
 * = 509. Fibonacci Number
 *
 * https://leetcode.com/problems/fibonacci-number/[Fibonacci Number - LeetCode^]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-04-25 22:06
 */
public class _0509_FibonacciNumber {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
     * Memory Usage: 36.3 MB, less than 5.51% of Java online submissions for Fibonacci Number.
     */
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
  // end::answer[]
}
