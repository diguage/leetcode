package com.diguage.algo.leetcode;

public class _0064_MinimumPathSum_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-18 21:51:48
   */
  public int minPathSum(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 1; i < col; i++) {
      grid[0][i] += grid[0][i - 1];
    }
    for (int i = 1; i < row; i++) {
      grid[i][0] += grid[i - 1][0];
    }
    for (int r = 1; r < row; r++) {
      for (int c = 1; c < col; c++) {
        grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
      }
    }
    return grid[row - 1][col - 1];
  }
  // end::answer[]
}
