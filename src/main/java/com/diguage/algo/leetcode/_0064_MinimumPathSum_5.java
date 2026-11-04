package com.diguage.algo.leetcode;

public class _0064_MinimumPathSum_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-04 23:05:48
   */
  public int minPathSum(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    for (int r = 1; r < row; r++) {
      grid[r][0] += grid[r - 1][0];
    }
    for (int c = 1; c < col; c++) {
      grid[0][c] += grid[0][c - 1];
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
