package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0300_LongestIncreasingSubsequence_4d {
  // tag::answer[]
  /**
   * 最长公共子序列解法
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-20 21:06:06
   */
  public int lengthOfLIS(int[] nums) {
    int[] ascNums = Arrays.stream(nums)
      .distinct().sorted().toArray();
    return lcs(nums, ascNums);
  }

  private int lcs(int[] a, int[] b) {
    int[][] dp = new int[a.length + 1][b.length + 1];
    for (int ai = 1; ai <= a.length; ai++) {
      for (int bi = 1; bi <= b.length; bi++) {
        dp[ai][bi] = Math.max(dp[ai][bi - 1], dp[ai - 1][bi]);
        if (a[ai - 1] == b[bi - 1]) {
          dp[ai][bi] = Math.max(dp[ai][bi], dp[ai - 1][bi - 1] + 1);
        }
      }
    }
    return dp[a.length][b.length];
  }

  // end::answer[]
  static void main() {
    new _0300_LongestIncreasingSubsequence_4d()
      .lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
//      .lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
  }
}
