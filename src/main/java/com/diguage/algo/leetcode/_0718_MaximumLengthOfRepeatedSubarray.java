package com.diguage.algo.leetcode;

public class _0718_MaximumLengthOfRepeatedSubarray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-30 20:18:46
   */
  public int findLength(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    int[][] dp = new int[n + 1][m + 1];
    int result = 0;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
        result = Math.max(result, dp[i][j]);
      }
    }
    return result;
  }
  // end::answer[]
}
