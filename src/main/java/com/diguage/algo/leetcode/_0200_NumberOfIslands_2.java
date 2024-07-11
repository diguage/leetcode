package com.diguage.algo.leetcode;

/**
 * = 200. Number of Islands
 *
 * Given a 2d grid map of `'1'`s (land) and `'0'`s (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * .Example 1:
 * [source]
 * ----
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * ----
 */
public class _0200_NumberOfIslands_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-11 20:04:34
   */
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          result++;
          dfs(grid, i, j);
        }
      }
    }
    return result;
  }

  private void dfs(char[][] grid, int row, int col) {
    if (row < 0 || grid.length <= row
      || col < 0 || grid[0].length <= col) {
      return;
    }
    if (grid[row][col] == '0' || grid[row][col] != '1') {
      return;
    }
    grid[row][col] = '2';
    dfs(grid, row - 1, col);// 上
    dfs(grid, row + 1, col);// 下
    dfs(grid, row, col - 1); // 左
    dfs(grid, row, col + 1); // 右
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0200_NumberOfIslands_2()
      .numIslands(new char[][]{
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}}
      );
  }
}
