package com.diguage.algo.leetcode;

public class _0062_UniquePaths_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-18 17:19:45
   */
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
  // end::answer[]
}
