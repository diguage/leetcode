package com.diguage.algo.leetcode;

public class _0994_RottingOranges {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-15 22:20:47
   */
  public int orangesRotting(int[][] grid) {
    int rotted = 2;
    while (rot(grid, rotted) > 0) {
      rotted++;
    }
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          return -1;
        }
      }
    }
    return rotted - 2;
  }

  private int rot(int[][] grid, int roted) {
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    int next = roted + 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] != roted) {
          continue;
        }
        grid[i][j] = next;
        // 上
        if (i > 0 && grid[i - 1][j] == 1) {
          grid[i - 1][j] = next;
          count++;
        }
        // 下
        if (i < m - 1 && grid[i + 1][j] == 1) {
          grid[i + 1][j] = next;
          count++;
        }
        // 左
        if (j > 0 && grid[i][j - 1] == 1) {
          grid[i][j - 1] = next;
          count++;
        }
        // 右
        if (j < n - 1 && grid[i][j + 1] == 1) {
          grid[i][j + 1] = next;
          count++;
        }
      }
    }
    return count;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0994_RottingOranges().orangesRotting(new int[][]{
      {2, 1, 1},
      {1, 1, 0},
      {0, 1, 1}
    });
  }
}
