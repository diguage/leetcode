package com.diguage.algo.leetcode;

public class _0718_MaximumLengthOfRepeatedSubarray_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-21 19:55:47
   */
  public int findLength(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    int[][] dp = new int[m + 1][n + 1];
    int result = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        // 只有在必要的时候采取更新 dp[i][j] 和 result
        // 简化一下，效率提高很多。
        if (nums1[i - 1] == nums2[j - 1]) {
          // 默认就是 0 ，则不需要再次设置为 0
          // ac == bc ? dp[i - 1][j - 1] + 1 : 0
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(result, dp[i][j]);
        }
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0718_MaximumLengthOfRepeatedSubarray_2()
      .findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1});
  }
}
