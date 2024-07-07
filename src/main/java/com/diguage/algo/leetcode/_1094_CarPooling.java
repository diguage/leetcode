package com.diguage.algo.leetcode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-05 15:01:49
 */
public class _1094_CarPooling {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-05 15:01:49
   */
  public boolean carPooling(int[][] trips, int capacity) {
    if (trips == null || trips.length == 0) {
      return true;
    }
    int length = Integer.MIN_VALUE;
    for (int[] trip : trips) {
      if (trip[0] > capacity) {
        return false;
      }
      length = Math.max(length, trip[2]);
    }
    // 差分数组
    int[] diff = new int[length + 1];
    for (int[] trip : trips) {
      int cap = trip[0];
      int start = trip[1];
      int end = trip[2];
      diff[start] += cap;
      if (diff[start] > capacity) {
        return false;
      }
      diff[end] -= cap;
    }
    for (int i = 1; i < diff.length; i++) {
      diff[i] += diff[i - 1];
      if (diff[i] > capacity) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
}
