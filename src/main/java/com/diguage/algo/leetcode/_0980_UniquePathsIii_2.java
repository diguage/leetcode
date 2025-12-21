package com.diguage.algo.leetcode;

public class _0980_UniquePathsIii_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-21 16:39:19
   */
  public int uniquePathsIII(int[][] grid) {
    int[] start = new int[2];
    int[] end = new int[2];
    int step = 0;
    for (int c = 0; c < grid.length; c++) {
      for (int r = 0; r < grid[c].length; r++) {
        if (grid[c][r] == 1) {
          start[0] = c;
          start[1] = r;
        } else if (grid[c][r] == 2) {
          end[0] = c;
          end[1] = r;
        } else if (grid[c][r] == 0) {
          step++;
        }
      }
    }
    return backtrack(grid, start, end, step + 1);
  }

  private int backtrack(int[][] grid, int[] start, int[] end, int step) {
    int column = start[0];
    int row = start[1];
    if (step == 0 && column == end[0] && row == end[1]) {
      return 1;
    }
    if (column < 0 || column >= grid.length
      || row < 0 || row >= grid[column].length
      || step < 0
      || (grid[column][row] != 1 && grid[column][row] != 0)) {
      return 0;
    }
    int origin = grid[column][row];
    int nextStep = step - 1;
    grid[column][row] = Integer.MAX_VALUE;
    int result = 0;
    // 上
    result += backtrack(grid, new int[]{column - 1, row}, end, nextStep);
    // 下
    result += backtrack(grid, new int[]{column + 1, row}, end, nextStep);
    // 左
    result += backtrack(grid, new int[]{column, row - 1}, end, nextStep);
    // 右
    result += backtrack(grid, new int[]{column, row + 1}, end, nextStep);

    grid[column][row] = origin;

    return result;
  }
  // end::answer[]

  static void main() {
    new _0980_UniquePathsIii_2().uniquePathsIII(new int[][]{
      {1, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 2, -1}});
  }
}
