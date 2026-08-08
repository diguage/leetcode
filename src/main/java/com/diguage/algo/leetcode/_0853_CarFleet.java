package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0853_CarFleet {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-08 22:38:10
   */
  public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    int[][] cars = new int[n][2];
    for (int i = 0; i < n; i++) {
      cars[i] = new int[]{position[i], speed[i]};
    }
    Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));
    int result = n;
    float ftarget = 0.0F + target;
    float time = (ftarget - cars[n - 1][0]) / cars[n - 1][1];
    for (int i = n - 2; i >= 0; i--) {
      int[] car = cars[i];
      float temp = (ftarget - car[0]) / car[1];
      if (temp <= time) {
        result--;
      } else {
        time = temp;
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0853_CarFleet()
//      .carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3});
      .carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3});
  }
}
