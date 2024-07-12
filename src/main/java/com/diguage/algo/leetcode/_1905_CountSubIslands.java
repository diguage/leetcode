package com.diguage.algo.leetcode;

public class _1905_CountSubIslands {
  // tag::answer[]
  /**
   * 借鉴沉岛思路
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-12 14:51:03
   */
  public int countSubIslands(int[][] grid1, int[][] grid2) {
    if (grid1 == null || grid1.length == 0 || grid1[0].length == 0
      || grid2 == null || grid2.length == 0 || grid2[0].length == 0) {
      return 0;
    }
    int m = grid1.length, n = grid1[0].length;
    // 把不是子岛的岛屿全部沉掉
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid1[r][c] == 0 && grid2[r][c] == 1) {
          dfs(grid2, r, c);
        }
      }
    }
    // 剩余岛屿即使岛屿数量
    int result = 0;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid1[r][c] == 1 && grid2[r][c] == 1) {
          result++;
          dfs(grid2, r, c);
        }
      }
    }
    return result;
  }

  private void dfs(int[][] grid, int r, int c) {
    if (r < 0 || grid.length <= r
      || c < 0 || grid[r].length <= c) {
      return;
    }
    if (grid[r][c] != 1) {
      return;
    }
    grid[r][c] = 2;
    dfs(grid, r - 1, c); // 上
    dfs(grid, r + 1, c); // 下
    dfs(grid, r, c - 1); // 左
    dfs(grid, r, c + 1); // 右
  }
  // end::answer[]
}
