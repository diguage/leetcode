package com.diguage.algo.leetcode;

public class _0892_SurfaceAreaOf3DShapes {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-26 16:32:11
   */
  public int surfaceArea(int[][] grid) {
    int n = grid.length;
    // 直接处理一根柱子的情况
    if (n == 1) {
      return (grid[0][0] > 0 ? 2 : 0) + (grid[0][0] * 4);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int high = grid[i][j];
        if (high > 0) {
          result += 2; // 上下两个面
        }
        if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
          // 把边
          result += high;
          // 矩阵四个顶点
          if ((i == 0 && j == 0)) {
            result += high;
          }
          if ((i == 0 && j == n - 1)) {
            result += high;
          }
          if ((i == n - 1 && j == 0)) {
            result += high;
          }
          if ((i == n - 1 && j == n - 1)) {
            result += high;
          }
        }
        if (i - 1 >= 0 && high > grid[i - 1][j]) {
          result += high - grid[i - 1][j];
        }
        if (i + 1 < n && high > grid[i + 1][j]) {
          result += high - grid[i + 1][j];
        }
        if (j - 1 >= 0 && high > grid[i][j - 1]) {
          result += high - grid[i][j - 1];
        }
        if (j + 1 < n && high > grid[i][j + 1]) {
          result += high - grid[i][j + 1];
        }
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0892_SurfaceAreaOf3DShapes()
      .surfaceArea(new int[][]{{1}});
  }
}
