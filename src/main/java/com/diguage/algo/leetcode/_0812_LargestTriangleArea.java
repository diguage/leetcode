package com.diguage.algo.leetcode;

public class _0812_LargestTriangleArea {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-06 22:54:18
   */
  public double largestTriangleArea(int[][] points) {
    double result = 0.0D;
    int n = points.length;
    for (int i = 0; i < n; i++) {
      int x1 = points[i][0];
      int y1 = points[i][1];
      for (int j = i + 1; j < n; j++) {
        int x2 = points[j][0];
        int y2 = points[j][1];
        for (int k = j + 1; k < n; k++) {
          int x3 = points[k][0];
          int y3 = points[k][1];
          int num = (x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3);
          result = Math.max(result, Math.abs(num));
        }
      }
    }
    return result / 2.0D;
  }
  // end::answer[]
}
