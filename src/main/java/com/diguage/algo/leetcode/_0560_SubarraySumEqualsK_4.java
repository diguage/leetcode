package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0560_SubarraySumEqualsK_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-12 21:00:06
   */
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> counter = new HashMap<>();
    counter.put(0, 1);
    int result = 0;
    int sum = 0;
    for (int num : nums) {
      sum += num;
      result += counter.getOrDefault(sum - k, 0);
      counter.put(sum, counter.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0560_SubarraySumEqualsK_4().subarraySum(new int[]{1, 2, 3}, 3);
  }
}
