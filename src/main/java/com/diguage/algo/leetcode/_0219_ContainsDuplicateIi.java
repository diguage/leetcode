package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0219_ContainsDuplicateIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-13 21:51:04
   */
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> numToIndexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (numToIndexMap.containsKey(num)
        && i - numToIndexMap.get(num) <= k) {
        return true;
      }
      numToIndexMap.put(num, i);
      // 看题解得到的启发，太远的值，存在也没意义。
      if (numToIndexMap.size() > k) {
        numToIndexMap.remove(nums[i - k]);
      }
    }
    return false;
  }
  // end::answer[]
}
