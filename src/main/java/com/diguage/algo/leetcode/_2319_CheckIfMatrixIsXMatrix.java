package com.diguage.algo.leetcode;

public class _2319_CheckIfMatrixIsXMatrix {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-21 17:39:01
   */
  public boolean checkXMatrix(int[][] grid) {
    int length = grid.length;
    for (int r = 0; r < length; r++) {
      if (grid[r][r] == 0) {
        return false;
      } else {
        grid[r][r] = -grid[r][r];
      }
      int c = length - 1 - r;
      if (grid[r][c] == 0) {
        return false;
      } else {
        if (grid[r][c] > 0) {
          grid[r][c] = -grid[r][c];
        }
      }
      // 上面处理同行对角线的数字，下面处理其余数字
      for (int cc = 0; cc < length; cc++) {
        if (grid[r][cc] > 0) {
          return false;
        }
      }
    }
    return true;
  }
  // end::answer[]
}
