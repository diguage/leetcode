package com.diguage.algo.leetcode;

import java.util.Objects;
import java.util.TreeMap;

public class _0846_HandOfStraights {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-03 21:37:17
   */
  public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) {
      return false;
    }
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i : hand) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    while (!map.isEmpty()) {
      Integer start = map.firstKey();
      for (int i = 0; i < groupSize; i++) {
        int curr = start + i;
        Integer cnt = map.get(curr);
        if (Objects.isNull(cnt)) {
          return false;
        } else if (cnt == 1) {
          map.remove(curr);
        } else {
          map.put(curr, cnt - 1);
        }
      }
    }
    return true;
  }

  // end::answer[]
  static void main() {
    new _0846_HandOfStraights().isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3);
  }
}
