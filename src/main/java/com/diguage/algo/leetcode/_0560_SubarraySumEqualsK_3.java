package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0560_SubarraySumEqualsK_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-26 23:25:38
   */
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> sumToCounterMap = new HashMap<>();
    // 在数组求前缀和之前，0 个元素的和是 0，也就是存在 1 个和是 0 的情况。
    sumToCounterMap.put(0, 1);
    int sum = 0;
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      result += sumToCounterMap.getOrDefault(sum - k, 0);
      sumToCounterMap.put(sum, sumToCounterMap.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
  // end::answer[]
}
