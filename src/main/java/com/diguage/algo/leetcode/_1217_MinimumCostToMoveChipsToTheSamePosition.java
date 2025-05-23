package com.diguage.algo.leetcode;

public class _1217_MinimumCostToMoveChipsToTheSamePosition {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-23 09:04:11
   */
  public int minCostToMoveChips(int[] position) {
    int odd = 0, even = 0;
    for (int num : position) {
      if ((num & 1) == 1) {
        odd++;
      } else {
        even++;
      }
    }
    return Math.min(odd, even);
  }
  // end::answer[]
}
