package com.diguage.algorithm.leetcode;

/**
 * = 371. Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers/[Sum of Two Integers - LeetCode]
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: a = 1, b = 2
 * Output: 3
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: a = -2, b = 3
 * Output: 1
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-25 17:03
 */
public class _0371_SumOfTwoIntegers {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Two Integers.
     *
     * Memory Usage: 37.9 MB, less than 6.67% of Java online submissions for Sum of Two Integers.
     */
    public int getSumLoop(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Two Integers.
     *
     * Memory Usage: 37.7 MB, less than 6.67% of Java online submissions for Sum of Two Integers.
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0371_SumOfTwoIntegers solution = new _0371_SumOfTwoIntegers();
        int r1 = solution.getSum(1, 2);
        System.out.println((r1 == 3) + " : " + r1);

        int r2 = solution.getSum(29, 23);
        System.out.println((r2 == 52) + " : " + r2);
    }
}
