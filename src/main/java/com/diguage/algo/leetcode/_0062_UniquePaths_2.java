package com.diguage.algo.leetcode;

public class _0062_UniquePaths_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-12 15:16:31
   */
  public int uniquePaths(int m, int n) {
    // 1. dp 表示走到某个节点一共有多少路径
    int[][] dp = new int[m][n];
    // 3. 第一行只有一种走法
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    // 3. 第一列也只有一种走法。
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    // 4. 遍历顺序：从左上逐步向右下遍历
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // 2. 由于只能从上或者从左走过来，
        //    那么路径数量就是两个节点相加
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
  // end::answer[]
}
