package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0849_MaximizeDistanceToClosestPerson {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-05 21:37:27
   */
  public int maxDistToClosest(int[] seats) {
    int n = seats.length;
    int[] right = new int[n];
    Arrays.fill(right, -1);
    int[] left = new int[n];
    Arrays.fill(left, -1);
    int index = -1;
    for (int i = 0; i < n; i++) {
      if (seats[i] == 1) {
        right[i] = 0;
        if (index < 0) {
          index = i;
        } else {
          index = n;
        }
        continue;
      }
      if (i > 0 && right[i - 1] >= 0) {
        right[i] = right[i - 1] + 1;
      }
    }
    // 只有一个人
    if (index < n) {
      return Math.max(index, n - index - 1);
    }
    for (int i = n - 1; i >= 0; i--) {
      if (seats[i] == 1) {
        left[i] = 0;
        continue;
      }
      if (i < n - 1 && 0 <= left[i + 1]) {
        left[i] = left[i + 1] + 1;
      }
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (right[i] >= 0 && left[i] >= 0) {
        result = Math.max(result, Math.min(right[i], left[i]));
      } else {
        result = Math.max(result, Math.max(right[i], left[i]));
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0849_MaximizeDistanceToClosestPerson()
      .maxDistToClosest(new int[]{0, 0, 1, 0, 1, 1});
//      .maxDistToClosest(new int[]{1, 0, 0, 0});
//      .maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1});
  }
}
