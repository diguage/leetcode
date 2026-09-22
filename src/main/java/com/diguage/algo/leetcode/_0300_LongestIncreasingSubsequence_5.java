package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0300_LongestIncreasingSubsequence_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-22 23:39:36
   */
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int result = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          result = Math.max(result, dp[i]);
        }
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0300_LongestIncreasingSubsequence_5()
      .lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
  }
}
