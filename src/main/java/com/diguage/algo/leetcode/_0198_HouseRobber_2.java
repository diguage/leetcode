package com.diguage.algo.leetcode;

public class _0198_HouseRobber_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-23 22:37
   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    // 1. 确定 dp 数组（dp table）以及下标的含义
    int[] dp = new int[nums.length];
    // 3. dp 数组如何初始化
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    // 4. 确定遍历顺序
    for (int i = 2; i < nums.length; i++) {
      // 2. 确定递推公式: max(dp[i-3]+nums[i], dp[i-2]+nums[i], dp[i-1])
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }
  // end::answer[]
}
