package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0300_LongestIncreasingSubsequence_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-08 16:55:25
   */
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    // 每个数都是一个子序列，满足严格递增
    Arrays.fill(dp, 1);
    int result = 1;
    // 双重循环等于将指定数nums[i]与前面的每一个数都去比较一下
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        result = Math.max(result, dp[i]);
      }
    }
    return result;
  }
  // end::answer[]
}
