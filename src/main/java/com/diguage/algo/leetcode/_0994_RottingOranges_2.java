package com.diguage.algo.leetcode;

public class _0994_RottingOranges_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-11 13:13:38
   */
  public int orangesRotting(int[][] grid) {
    int rotted = 2;
    while (rot(grid, rotted) > 0) {
      rotted++;
    }
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] == 1) {
          return -1;
        }
      }
    }
    return rotted - 2;
  }

  private int rot(int[][] grid, int rotted) {
    int count = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] == rotted) {
          // 上
          if (0 <= r - 1 && grid[r - 1][c] == 1) {
            grid[r - 1][c] = rotted + 1;
            count++;
          }
          // 下
          if (r + 1 < grid.length && grid[r + 1][c] == 1) {
            grid[r + 1][c] = rotted + 1;
            count++;
          }
          // 左
          if (0 <= c - 1 && grid[r][c - 1] == 1) {
            grid[r][c - 1] = rotted + 1;
            count++;
          }
          // 右
          if (c + 1 < grid[r].length && grid[r][c + 1] == 1) {
            grid[r][c + 1] = rotted + 1;
            count++;
          }
        }
      }
    }
    return count;
  }
  // end::answer[]
}
