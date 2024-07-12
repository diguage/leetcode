package com.diguage.algo.leetcode;

public class _1905_CountSubIslands_1 {
  // tag::answer[]

  /**
   * 直接判断，把不是子岛的地方修改掉，
   * 因为有重复访问，所以效率更低，不如沉岛来的快
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
    // 剩余岛屿即使岛屿数量
    int result = 0;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid1[r][c] == 1 && grid2[r][c] == 1) {
          boolean subIsland = dfs(grid1, grid2, r, c);
          if (subIsland) {
            result++;
          }
        }
      }
    }
    return result;
  }

  private boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {
    if (r < 0 || grid1.length <= r
      || c < 0 || grid1[r].length <= c) {
      return true;
    }
    if (grid1[r][c] == 0 && grid2[r][c] == 0) {
      return true;
    }
    if (grid1[r][c] == 0 && grid2[r][c] == 1) {
      dfs(grid2, r, c);
      return false;
    }
    if (grid1[r][c] == 0 && grid2[r][c] == 2) {
      return false;
    }
    if (grid1[r][c] == 1 && grid2[r][c] == 0) {
      return true;
    }
    if (grid1[r][c] == 1 && grid2[r][c] == 2) {
      return true;
    }
    grid2[r][c] = 2;
    return dfs(grid1, grid2, r - 1, c) // 上
      && dfs(grid1, grid2, r + 1, c) // 下
      && dfs(grid1, grid2, r, c - 1) // 左
      && dfs(grid1, grid2, r, c + 1); // 右
  }

  private void dfs(int[][] grid, int r, int c) {
    if (r < 0 || grid.length <= r
      || c < 0 || grid[r].length <= c) {
      return;
    }
    if (grid[r][c] == 0 || grid[r][c] == 3) {
      return;
    }
    grid[r][c] = 3;
    dfs(grid, r - 1, c); // 上
    dfs(grid, r + 1, c); // 下
    dfs(grid, r, c - 1); // 左
    dfs(grid, r, c + 1); // 右
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1905_CountSubIslands_1().countSubIslands(
      new int[][]{
        {1, 0, 1, 0, 1},
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1},
        {1, 0, 1, 0, 1}},
      new int[][]{
        {0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1},
        {0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0},
        {1, 0, 0, 0, 1}});
  }
}
