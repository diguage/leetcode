package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0594_LongestHarmoniousSubsequence {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-30 21:44
   */
  public int findLHS(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int result = 0;
    for (int num : nums) {
      if (map.containsKey(num - 1)) {
        result = Math.max(result, map.get(num - 1) + map.get(num));
      }
    }
    return result;
  }
  // end::answer[]
}
