package com.diguage.algo.leetcode;

public class _1480_RunningSumOf1DArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 23:14:43
   */
  public int[] runningSum(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = nums[i] + dp[i - 1];
    }
    return dp;
  }
  // end::answer[]
}
