package com.diguage.algo.leetcode;

public class _0064_MinimumPathSum_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-27 21:29
   */
  public int minPathSum(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < grid[0].length; i++) {
      dp[0][i] = grid[0][i] + dp[0][i - 1];
    }
    for (int i = 1; i < grid.length; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }
    for (int row = 1; row < grid.length; row++) {
      for (int column = 1; column < grid[0].length; column++) {
        dp[row][column] = Math.min(dp[row - 1][column], dp[row][column - 1])
          + grid[row][column];
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }
  // end::answer[]
}
