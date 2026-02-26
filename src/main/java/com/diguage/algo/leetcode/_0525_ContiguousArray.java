package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0525_ContiguousArray {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-26 23:02:06
   */
  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> position = new HashMap<>();
    // 前缀和数组的首项 0 相当于在 -1 下标
    position.put(0, -1);
    int sum = 0, result = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += (nums[i] == 0 ? -1 : 1);
      if (position.containsKey(sum)) {
        result = Math.max(result, i - position.get(sum));
      } else {
        position.put(sum, i);
      }
    }
    return result;
  }
  // end::answer[]
}
