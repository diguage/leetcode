package com.diguage.algo.leetcode;

import java.util.Objects;

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
    int[][] dp = new int[nums1.length][nums2.length];
    for (int i = 0; i < nums1.length; i++) {
      if (Objects.equals(nums1[i], nums2[0])) {
        dp[i][0] = 1;
        result = 1;
      }
    }
    for (int i = 1; i < nums2.length; i++) {
      if (Objects.equals(nums1[0], nums2[i])) {
        dp[0][i] = 1;
        result = 1;
      }
    }
    for (int i = 1; i < nums1.length; i++) {
      for (int j = 1; j < nums2.length; j++) {
        if (Objects.equals(nums1[i], nums2[j])) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(result, dp[i][j]);
        }
      }
    }
    return result;
  }
  // end::answer[]
}
