package com.diguage.algo.leetcode;

public class _0200_NumberOfIslands_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-06 15:18:59
   */
  public int numIslands(char[][] grid) {
    int result = 0;

    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] == '1') {
          result++;
          dfs(grid, r, c);
        }
      }
    }
    return result;
  }

  private void dfs(char[][] grid, int r, int c) {
    if (r < 0 || grid.length <= r
      || c < 0 || grid[r].length <= c
      || grid[r][c] != '1') {
      return;
    }
    grid[r][c] = '2';
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }
  // end::answer[]

  public static void main(String[] args) {
    char[][] grid = {
      {'1', '0', '1', '1', '1' },
      {'1', '0', '1', '0', '1' },
      {'1', '1', '1', '0', '1' }};
    new _0200_NumberOfIslands_3().numIslands(grid);
  }
}
