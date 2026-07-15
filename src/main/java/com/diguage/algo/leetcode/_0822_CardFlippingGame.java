package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0822_CardFlippingGame {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-15 22:52:49
   */
  public int flipgame(int[] fronts, int[] backs) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < fronts.length; i++) {
      if (fronts[i] == backs[i]) {
        set.add(fronts[i]);
      }
    }
    int result = Integer.MAX_VALUE;
    for (int front : fronts) {
      if (!set.contains(front)) {
        result = Math.min(result, front);
      }
    }
    for (int back : backs) {
      if (!set.contains(back)) {
        result = Math.min(result, back);
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }
  // end::answer[]
}
