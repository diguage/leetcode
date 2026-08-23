package com.diguage.algo.leetcode;

public class _0883_ProjectionAreaOf3DShapes {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-23 19:00:37
   */
  public int projectionArea(int[][] grid) {
    int xy = 0;
    int xz = 0;
    int yz = 0;
    int n = grid.length;
    for (int c = 0; c < n; c++) {
      int y = 0;
      int z = 0;
      for (int r = 0; r < n; r++) {
        yz += grid[r][c] > 0 ? 1 : 0;
        y = Math.max(y, grid[c][r]);
        z = Math.max(z, grid[r][c]);
      }
      yz += y;
      yz += z;
    }
    return xy + xz + yz;
  }
  // end::answer[]
}
