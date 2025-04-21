package com.diguage.algo.leetcode;

public class _1143_LongestCommonSubsequence {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-21 20:25:23
   */
  public int longestCommonSubsequence(String t, String s) {
    int m = t.length(), n = s.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (t.charAt(i - 1) == s.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }
  // end::answer[]
}
