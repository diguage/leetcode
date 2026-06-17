package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _0781_RabbitsInForest {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-17 22:19:42
   */
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> counter = new TreeMap<>();
    for (int num : answers) {
      counter.put(num, counter.getOrDefault(num, 0) + 1);
    }
    List<Integer> nums = new ArrayList<>(counter.size());
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
      int k = entry.getKey();
      int v = entry.getValue();
      if (v % (k + 1) == 0) {
        result += v;
      } else {
        result += (v / (k + 1) + 1) * (k + 1);
      }
    }
    return result;
  }
  // end::answer[]
}
