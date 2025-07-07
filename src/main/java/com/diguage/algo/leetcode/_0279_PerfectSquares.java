package com.diguage.algo.leetcode;

/**
 * = 279. Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/[Perfect Squares - LeetCode]
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, `1`, `4`, `9`, `16`, `...`) which sum to n.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-24 11:34
 */
public class _0279_PerfectSquares {
  // tag::answer[]
    /**
     * Runtime: 45 ms, faster than 31.57% of Java online submissions for Perfect Squares.
     *
     * Memory Usage: 41.2 MB, less than 13.89% of Java online submissions for Perfect Squares.
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-24 11:34
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1，也就是分解为 i 个 1*1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

  // end::answer[]


    public static void main(String[] args) {
        _0279_PerfectSquares solution = new _0279_PerfectSquares();
        int r1 = solution.numSquares(12);
        System.out.println((r1 == 3) + " : " + r1);

        int r2 = solution.numSquares(13);
        System.out.println((r2 == 2) + " : " + r2);
    }
}
