package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0575_DistributeCandies {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-21 21:08:01
   */
  public int distributeCandies(int[] candyType) {
    Set<Integer> types = new HashSet<>(candyType.length / 2);
    for (int i : candyType) {
      types.add(i);
      if (types.size() > candyType.length / 2) {
        return candyType.length / 2;
      }
    }
    return Math.min(types.size(), candyType.length / 2);
  }
  // end::answer[]
}
