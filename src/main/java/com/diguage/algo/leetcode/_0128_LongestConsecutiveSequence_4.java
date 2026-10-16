package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-16 23:29:43
   */
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Set<Integer> set = new HashSet<>(nums.length);
    for (int num : nums) {
      set.add(num);
    }
    int result = 0;
    for (int num : nums) {
      // 找出连续序列里最小的数作为起点。这是这道题的第一个亮点
      if (set.contains(num - 1)) {
        continue;
      }
      int temp = 0;
      while (set.contains(num++)) {
        temp++;
      }
      result = Math.max(result, temp);
      // 这是这道题的第二个亮点。仔细体会一下，为什么可以准确找出最长连续长度？！
      if (2 * result > nums.length) {
        break;
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0128_LongestConsecutiveSequence_4()
      .longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
  }
}
