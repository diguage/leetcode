package com.diguage.algo.leetcode;

public class _0718_MaximumLengthOfRepeatedSubarray_31c {
  // tag::answer[]
  /**
   * 暴力破解（42/55）→ 备忘录（5.22%）→ 动态规划
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-29 19:53:46
   */
  public int findLength(int[] nums1, int[] nums2) {
    int result = 0;
    int[][] dp = new int[nums1.length + 1][nums2.length + 1];
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        if (nums1[i] == nums2[j]) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
          result = Math.max(result, dp[i + 1][j + 1]);
        }
      }
    }
    return result;
  }
  // end::answer[]
}
