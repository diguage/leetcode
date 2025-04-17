package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0213_HouseRobberIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-17 14:52:14
   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length - 1; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    int inOne = dp[nums.length - 2];
    Arrays.fill(dp, 0);
    dp[nums.length - 1] = nums[nums.length - 1];
    dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    for (int i = nums.length - 3; i > 0; i--) {
      dp[i] = Math.max(dp[i + 2] + nums[i], dp[i + 1]);
    }
    return Math.max(inOne, dp[1]);
  }
  // end::answer[]
}
