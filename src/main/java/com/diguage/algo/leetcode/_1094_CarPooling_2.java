package com.diguage.algo.leetcode;

public class _1094_CarPooling_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-07 17:59:13
   */
  public boolean carPooling(int[][] trips, int capacity) {
    int length = Integer.MIN_VALUE;
    for (int[] trip : trips) {
      if (trip[0] > capacity) {
        return false;
      }
      length = Math.max(length, trip[2]);
    }
    int[] array = new int[length + 1];
    for (int[] trip : trips) {
      int start = trip[1];
      int end = trip[2];
      int num = trip[0];
      array[start] += num;
      if (array[start] > capacity) {
        return false;
      }
      array[end] -= num;
    }
    for (int i = 1; i < array.length; i++) {
      array[i] += array[i - 1];
      if (array[i] > capacity) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
}
