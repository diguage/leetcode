package com.diguage.algo.leetcode;

/**
 * = 172. Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/[Factorial Trailing Zeroes - LeetCode]
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * ----
 *
 * *Note:* Your solution should be in logarithmic time complexity.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-14 12:11
 */
public class _0172_FactorialTrailingZeroes {
  // tag::answer[]

    /**
     * Runtime: 1 ms, faster than 97.29% of Java online submissions for Factorial Trailing Zeroes.
     *
     * Memory Usage: 34 MB, less than 7.69% of Java online submissions for Factorial Trailing Zeroes.
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0172_FactorialTrailingZeroes solultion = new _0172_FactorialTrailingZeroes();
        int r1 = solultion.trailingZeroes(5);
        System.out.println((r1 == 1) + " : " + r1);

        int r2 = solultion.trailingZeroes(100);
        System.out.println((r2 == 1) + " : " + r2);

        int r3 = solultion.trailingZeroes(30);
        System.out.println((r3 == 7) + " : " + r3);

        int r4 = solultion.trailingZeroes(200);
        System.out.println((r4 == 49) + " : " + r4);
    }
}
