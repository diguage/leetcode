package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-22 14:32:50
   */
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int num : nums) {
      set.add(num);
    }
    int result = 0;
    // 这里使用 set 遍历即可。使用 nums 超时
    for (int num : set) {
      int count = 1;
      if (!set.contains(num - 1)) {
        // 如果集合中包含目标数字，则遍历，否则就退出
        for (int i = num + 1; set.contains(i); i++) {
          count++;
        }
      }
      result = Math.max(result, count);
    }
    return result;
  }
  // end::answer[]
}
