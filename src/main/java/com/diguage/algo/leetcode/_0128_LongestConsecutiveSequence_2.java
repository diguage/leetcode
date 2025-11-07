package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence_2 {
  // tag::answer[]

  /**
   * 优化前，通过 73 / 83 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-02-07 23:56
   */
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int num : nums) {
      set.add(num);
    }
    int result = 0;
    for (int num : set) {
      if (set.contains(num - 1)) {
        continue;
      }
      int count = 1;
      for (int i = num + 1; set.contains(i); i++) {
        count++;
      }
      result = Math.max(result, count);
      // 已经有一个连续数列超过了一半，则不会出现更大的数列了。
      if (result * 2 >= set.size()) {
        break;
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
