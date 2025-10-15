package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0300_LongestIncreasingSubsequence_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-15 23:00:36
   */
  public int lengthOfLIS(int[] nums) {
    int[] clone = Arrays.stream(nums)
      .distinct()
      .sorted()
      .toArray();
    Arrays.sort(clone);
    return lcs(nums, clone);
  }

  private int lcs(int[] nums, int[] clone) {
    int[][] dp = new int[nums.length + 1][clone.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      for (int j = 1; j <= clone.length; j++) {
        if (nums[i - 1] == clone[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[nums.length][clone.length];
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0300_LongestIncreasingSubsequence_3().lengthOfLIS(new int[]{});
  }
}
