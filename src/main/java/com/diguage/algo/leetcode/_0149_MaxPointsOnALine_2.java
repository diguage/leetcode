package com.diguage.algo.leetcode;

import java.util.*;

public class _0149_MaxPointsOnALine_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-30 21:59:25
   */
  public int maxPoints(int[][] points) {
    int result = 1;
    for (int i = 0; i < points.length; i++) {
      int[] p1 = points[i];
      for (int j = i + 1; j < points.length; j++) {
        int curr = 2;
        int[] p2 = points[j];
        for (int k = j + 1; k < points.length; k++) {
          int[] p3 = points[k];
          if ((p3[0] - p2[0]) * (p1[1] - p2[1]) == (p1[0] - p2[0]) * (p3[1] - p2[1])) {
            curr++;
          }
        }
        result = Math.max(result, curr);
      }
    }
    return result;
  }
  // end::answer[]
}
