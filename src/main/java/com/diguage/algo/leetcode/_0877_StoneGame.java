package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0877_StoneGame {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-21 22:24:03
   */
  public boolean stoneGame(int[] piles) {
    Arrays.sort(piles);
    int sum = 0, bob = 0;
    for (int i = 0; i < piles.length; i++) {
      sum += piles[i];
      if ((i & 1) == 0) {
        bob++;
      }
    }
    return sum > 2 * bob;
  }
  // end::answer[]
}
