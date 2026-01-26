package com.diguage.algo.leetcode;

public class _1217_MinimumCostToMoveChipsToTheSamePosition_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-26 21:49:48
   */
  public int minCostToMoveChips(int[] position) {
    int even = 0, odd = 0;
    for (int pos : position) {
      if ((pos & 1) == 1) {
        odd++;
      } else {
        even++;
      }
    }
    return Math.min(even, odd);
  }
  // end::answer[]
}
