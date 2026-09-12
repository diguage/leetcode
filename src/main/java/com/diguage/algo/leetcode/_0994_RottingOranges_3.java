package com.diguage.algo.leetcode;

public class _0994_RottingOranges_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-12 22:00:18
   */
  public int orangesRotting(int[][] grid) {
    int cnt = 0;
    for (int[] ints : grid) {
      for (int o : ints) {
        if (o == 1) {
          cnt++;
        }
      }
    }
    int result = 2;
    while (cnt > 0) {
      int roted = bfs(grid, result);
      if (roted == 0) {
        return -1;
      }
      cnt -= roted;
      result++;
    }
    return result - 2;
  }

  private int bfs(int[][] grid, int curr) {
    int roted = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] != curr) {
          continue;
        }
        // 上
        int next = curr + 1;
        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
          roted++;
          grid[r - 1][c] = next;
        }
        // 下
        if (r + 1 < grid.length && grid[r + 1][c] == 1) {
          roted++;
          grid[r + 1][c] = next;
        }
        // 左
        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
          roted++;
          grid[r][c - 1] = next;
        }
        // 右
        if (c + 1 < grid[r].length && grid[r][c + 1] == 1) {
          roted++;
          grid[r][c + 1] = next;
        }
      }
    }
    return roted;
  }
  // end::answer[]
}

