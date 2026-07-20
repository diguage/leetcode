package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0830_PositionsOfLargeGroups {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-20 22:31:30
   */
  public List<List<Integer>> largeGroupPositions(String s) {
    List<List<Integer>> result = new ArrayList<>();
    int left = 0, right = 1;
    while (right <= s.length()) {
      if (right == s.length() || s.charAt(right - 1) != s.charAt(right)) {
        if (right - left >= 3) {
          result.add(List.of(left, right - 1));
        }
        left = right;
      }
      right++;
    }
    return result;
  }
  // end::answer[]
}
