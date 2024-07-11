package com.diguage.algo.leetcode;

public class _0695_MaxAreaOfIsland {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-11 21:33:21
   */
  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int result = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] == 1) {
          int a = dfs(grid, r, c);
          result = Math.max(result, a);
        }
      }
    }
    return result;
  }

  private int dfs(int[][] grid, int r, int c) {
    if (r < 0 || grid.length <= r
      || c < 0 || grid[r].length <= c) {
      return 0;
    }
    if (grid[r][c] == 0 || grid[r][c] == 2) {
      return 0;
    }
    grid[r][c] = 2;
    return 1
      // 上
      + dfs(grid, r - 1, c)
      // 下
      + dfs(grid, r + 1, c)
      // 左
      + dfs(grid, r, c - 1)
      // 右
      + dfs(grid, r, c + 1);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0695_MaxAreaOfIsland()
      .maxAreaOfIsland(new int[][]{
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
      });
  }
}
