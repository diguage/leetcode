package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-02-07 23:56
   */
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Set<Integer> set = new HashSet<>(nums.length);
    for (int num : nums) {
      set.add(num);
    }
    int result = 1;
    int left = 0, right = -1;
    while (!set.isEmpty()) {
      if (left > right) {
        Integer next = set.iterator().next();
        set.remove(next);
        left = right = next;
      } else {
        int size = right - left + 1;
        int pre = left - 1;
        boolean hasPre = set.remove(pre);
        if (hasPre) {
          left = pre;
        }
        int next = right + 1;
        boolean hasNext = set.remove(next);
        if (hasNext) {
          right = next;
        }
        result = Math.max(result, right - left + 1);
        if (size == right - left + 1) {
          left = 0;
          right = -1;
        }
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0128_LongestConsecutiveSequence_2()
      .longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
  }
}
