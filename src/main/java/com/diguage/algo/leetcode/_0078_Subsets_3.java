package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0078_Subsets_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-16 20:09:31
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>(1 << nums.length);
    result.add(new ArrayList<>());
    for (int num : nums) {
      int size = result.size();
      for (int i = 0; i < size; i++) {
        List<Integer> existed = result.get(i);
        List<Integer> adding = new ArrayList<>(existed);
        adding.add(num);
        result.add(adding);
      }
    }
    return result;
  }
  // end::answer[]
}
