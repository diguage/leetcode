package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0135_Candy_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-29 20:10:15
   */
  public int candy(int[] ratings) {
    int[] can = new int[ratings.length];
    Arrays.fill(can, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i - 1] < ratings[i]) {
        can[i] = can[i - 1] + 1;
      }
    }
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1] && can[i] <= can[i + 1]) {
        can[i] = can[i + 1] + 1;
      }
    }
    return Arrays.stream(can).sum();
  }
  // end::answer[]
}
