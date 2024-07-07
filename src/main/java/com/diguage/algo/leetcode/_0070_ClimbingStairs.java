package com.diguage.algo.leetcode;

/**
 * = 70. Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/[Climbing Stairs - LeetCode]
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * *Note:* Given n will be a positive integer.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * ----
 *
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-23 21:29
 */
public class _0070_ClimbingStairs {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     *
     * Memory Usage: 40.8 MB, less than 5.26% of Java online submissions for Climbing Stairs.
     *
     * Copy from: https://leetcode.com/problems/climbing-stairs/solution/[Climbing Stairs solution - LeetCode]
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

  // end::answer[]


    public static void main(String[] args) {
        _0070_ClimbingStairs solution = new _0070_ClimbingStairs();
        int r1 = solution.climbStairs(2);
        System.out.println((r1 == 2) + " : " + r1);

        int r2 = solution.climbStairs(3);
        System.out.println((r2 == 3) + " : " + r2);

        int r3 = solution.climbStairs(4);
        System.out.println((r3 == 5) + " : " + r3);
    }
}
