package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0677_MapSumPairs {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-07 23:24:40
   */
  class MapSum {
    private Map<String, Integer> map;

    public MapSum() {
      map = new HashMap<>();
    }

    public void insert(String key, int val) {
      map.put(key, val);
    }

    public int sum(String prefix) {
      int sum = 0;
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getKey().startsWith(prefix)) {
          sum += entry.getValue();
        }
      }
      return sum;
    }
  }
  // end::answer[]
}
