package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0560_SubarraySumEqualsK_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-14 21:48:16
   */
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int result = 0;
    int sum = 0;
    for (int num : nums) {
      sum += num;
      result += map.getOrDefault(sum - k, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
  // end::answer[]
}
