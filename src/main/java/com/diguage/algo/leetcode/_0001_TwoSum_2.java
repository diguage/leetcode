package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0001_TwoSum_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-06 16:36:45
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numToIdx = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (numToIdx.containsKey(target - num)) {
        return new int[]{numToIdx.get(target - num), i};
      } else {
        numToIdx.put(num, i);
      }
    }
    return null;
  }
  // end::answer[]
}
