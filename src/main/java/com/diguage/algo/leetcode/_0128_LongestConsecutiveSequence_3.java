package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-01 10:59:06
   */
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int result = 0;
    for (Integer num : set) {
      if (set.contains(num - 1)) {
        continue;
      }
      int start = num;
      while (set.contains(num)) {
        num++;
      }
      result = Math.max(result, num - start);
      // 小优化：当连续序列长度超过集合的一半，就不会再出现更长的连续序列了。
      if (2 * result >= set.size()) {
        break;
      }
    }
    return result;
  }
  // end::answer[]
}
