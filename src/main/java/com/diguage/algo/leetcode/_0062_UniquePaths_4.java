package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0062_UniquePaths_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-22 23:28:47
   */
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    Arrays.fill(dp[0], 1);
    for (int c = 1; c < m; c++) {
      dp[c][0] = 1;
      for (int r = 1; r < n; r++) {
        dp[c][r] = dp[c - 1][r] + dp[c][r - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
  // end::answer[]
}
