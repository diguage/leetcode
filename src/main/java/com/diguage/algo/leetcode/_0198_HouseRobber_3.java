package com.diguage.algo.leetcode;

public class _0198_HouseRobber_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-16 20:19:02
   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    nums[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      // dp[i] = max(nums[i] + dp[i-2], dp[i-1])
      nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
    }
    return nums[nums.length - 1];
  }
  // end::answer[]
}
