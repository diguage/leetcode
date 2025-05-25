package com.diguage.algo.leetcode;

public class _1020_NumberOfEnclaves {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-25 22:52:15
   */
  public int numEnclaves(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    for (int i = 0; i < row; i++) {
      if (grid[i][0] == 1) {
        dfs(grid, i, 0);
      }
      if (grid[i][col - 1] == 1) {
        dfs(grid, i, col - 1);
      }
    }
    for (int i = 0; i < col; i++) {
      if (grid[0][i] == 1) {
        dfs(grid, 0, i);
      }
      if (grid[row - 1][i] == 1) {
        dfs(grid, row - 1, i);
      }
    }
    int result = 0;
    for (int i = 1; i < row - 1; i++) {
      for (int j = 1; j < grid[i].length - 1; j++) {
        if (grid[i][j] == 1) {
          result++;
        }
      }
    }
    return result;
  }

  private void dfs(int[][] grid, int row, int column) {
    if (row < 0 || row >= grid.length
      || column < 0 || column >= grid[row].length) {
      return;
    }
    if (grid[row][column] != 1) {
      return;
    }
    grid[row][column] = -1;
    // 上
    dfs(grid, row - 1, column);
    // 下
    dfs(grid, row + 1, column);
    // 左
    dfs(grid, row, column - 1);
    // 右
    dfs(grid, row, column + 1);
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1020_NumberOfEnclaves().numEnclaves(new int[][]{
      {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
      {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
      {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
      {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
      {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
      {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
      {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
      {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
      {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}
    });
  }
}
