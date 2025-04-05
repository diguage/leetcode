package com.diguage.algo.leetcode;

public class _0053_MaximumSubarray_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-05 11:05:10
   */
  public int maxSubArray(int[] nums) {
    // 这里还可以优化成一个 int 型变量
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int result = dp[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      result = Math.max(result, dp[i]);
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0053_MaximumSubarray_2().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
  }
}
