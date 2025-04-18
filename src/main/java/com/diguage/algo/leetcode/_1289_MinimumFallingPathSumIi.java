package com.diguage.algo.leetcode;

public class _1289_MinimumFallingPathSumIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-18 22:56:34
   */
  public int minFallingPathSum(int[][] grid) {
    int len = grid.length;
    if (len == 1) {
      return grid[0][0];
    }
    int result = Integer.MAX_VALUE;
    for (int r = 1; r < len; r++) {
      for (int c = 0; c < len; c++) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
          if (i == c) {
            continue;
          }
          min = Math.min(min, grid[r - 1][i]);
        }
        grid[r][c] += min;
        if (r == len - 1) {
          result = Math.min(result, grid[r][c]);
        }
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1289_MinimumFallingPathSumIi().minFallingPathSum(new int[][]{
      {-73, 61, 43, -48, -36},
      {3, 30, 27, 57, 10},
      {96, -76, 84, 59, -15},
      {5, -49, 76, 31, -7},
      {97, 91, 61, -46, 67}});
  }
}
