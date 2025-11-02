package com.diguage.algo.leetcode;

public class _0053_MaximumSubarray_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-02 11:27:26
   */
  public int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int result = dp[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      // 等价于 dp[i] = Math.max(dp[i - 1], 0) + nums[i];
      result = Math.max(result, dp[i]);
    }
    return result;
  }
  // end::answer[]
}
