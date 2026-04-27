package com.diguage.algo.leetcode;

public class _0664_StrangePrinter {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-27 21:36:26
   */
  public int strangePrinter(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = n - 1; i >= 0; i--) {
      dp[i][i] = 1;
      for (int j = i + 1; j < n; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i][j - 1];
        } else {
          int min = Integer.MAX_VALUE;
          for (int k = i; k < j; k++) {
            min = Math.min(min, dp[i][k] + dp[k + 1][j]);
          }
          dp[i][j] = min;
        }
      }
    }
    return dp[0][n - 1];
  }
  // end::answer[]
}
