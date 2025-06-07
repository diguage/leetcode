package com.diguage.algo.leetcode;

public class _0149_MaxPointsOnALine {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-07 21:55:30
   */
  public int maxPoints(int[][] points) {
    int length = points.length;
    int result = 1;
    for (int i = 0; i < length; i++) {
      int[] a = points[i];
      for (int j = i + 1; j < length; j++) {
        int[] b = points[j];
        int cnt = 2;
        for (int k = j + 1; k < length; k++) {
          int[] c = points[k];
          int m1 = (b[0] - c[0]) * (a[1] - b[1]);
          int m2 = (a[0] - b[0]) * (b[1] - c[1]);
          if (m1 == m2) {
            cnt++;
          }
        }
        result = Math.max(result, cnt);
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0149_MaxPointsOnALine()
      .maxPoints(new int[][]{{3, 3}, {1, 4}, {1, 1}, {2, 1}, {2, 2}});
  }
}
