package com.diguage.algo.leetcode;

public class _0062_UniquePaths_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-05 22:13:25
   */
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    for (int r = 1; r < m; r++) {
      dp[r][0] = 1;
      for (int c = 1; c < n; c++) {
        dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
  // end::answer[]
}
