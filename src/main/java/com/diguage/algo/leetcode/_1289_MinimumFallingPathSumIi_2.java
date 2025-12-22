package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1289_MinimumFallingPathSumIi_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-22 22:04:32
   */
  public int minFallingPathSum(int[][] grid) {
    if (grid.length == 1) {
      return Arrays.stream(grid[0]).min().getAsInt();
    }
    int result = Integer.MAX_VALUE;
    for (int c = 1; c < grid.length; c++) {
      for (int r = 0; r < grid[c].length; r++) {
        grid[c][r] += min(grid[c - 1], r);
        if (c == grid.length - 1) {
          result = Math.min(result, grid[c][r]);
        }
      }
    }
    return result;
  }

  private int min(int[] ints, int r) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < ints.length; i++) {
      if (i == r) {
        continue;
      }
      result = Math.min(result, ints[i]);
    }
    return result;
  }
  // end::answer[]
}
