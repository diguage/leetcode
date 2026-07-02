package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0807_MaxIncreaseToKeepCitySkyline {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-02 21:25:00
   */
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int n = grid.length;
    int[][] candidate = new int[n][n];
    for (int[] can : candidate) {
      Arrays.fill(can, 101);
    }
    // 处理每行
    for (int i = 0; i < n; i++) {
      int height = Arrays.stream(grid[i]).max().getAsInt();
      int[] can = candidate[i];
      for (int j = 0; j < n; j++) {
        can[j] = Math.min(can[j], height);
      }
    }

    // 处理每列
    for (int i = 0; i < n; i++) {
      int height = 0;
      for (int j = 0; j < n; j++) {
        height = Math.max(height, grid[j][i]);
      }
      for (int j = 0; j < n; j++) {
        candidate[j][i] = Math.min(candidate[j][i], height);
      }
    }

    int result = 0;
    for (int i = 0; i < candidate.length; i++) {
      result += Arrays.stream(candidate[i]).sum();
      result -= Arrays.stream(grid[i]).sum();
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0807_MaxIncreaseToKeepCitySkyline()
      .maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}});
  }
}
