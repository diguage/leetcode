package com.diguage.algo.leetcode;

public class _0198_HouseRobber_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-28 22:12:44
   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    // 修正 nums[1]，使其符合 nums[i] 是 0~i 元素中最大抢劫金额
    nums[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      // dp[i] = max(nums[i] + dp[i-2], dp[i-1])
      nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
    }
    return nums[nums.length - 1];
  }
  // end::answer[]
}
