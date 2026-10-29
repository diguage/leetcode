package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0078_Subsets_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-29 23:35:33
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>(nums.length * (nums.length - 1));
    result.add(List.of());
    for (int num : nums) {
      int size = result.size();
      for (int i = 0; i < size; i++) {
        List<Integer> next = new ArrayList<>(result.get(i));
        next.add(num);
        result.add(next);
      }
    }
    return result;
  }
  // end::answer[]
}
