package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _3111_MinimumRectanglesToCoverPoints {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-21 22:07:28
   */
  public int minRectanglesToCoverPoints(int[][] points, int w) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    Map<Integer, Integer> x2y = new HashMap<>();
    for (int[] point : points) {
      int x = point[0];
      int y = point[1];
      min = Math.min(min, x);
      max = Math.max(max, x);
      x2y.put(x, Math.max(x2y.getOrDefault(x, 0), y));
    }
    if (w == 0) {
      return x2y.size();
    }
    int result = 0;
    int iw = w;
    boolean flag = false;
    for (int i = min; i <= max; i++) {
      if (!flag && x2y.containsKey(i)) {
        flag = true;
      }
      if (flag) {
        iw--;
      }
      if (iw < 0 || i == max) {
        result++;
        flag = false;
        iw = w;
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _3111_MinimumRectanglesToCoverPoints()
      .minRectanglesToCoverPoints(new int[][]{
        {0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}}, 2);
  }
}
