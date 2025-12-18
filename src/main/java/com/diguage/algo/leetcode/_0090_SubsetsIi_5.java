package com.diguage.algo.leetcode;

import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0090_SubsetsIi_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-18 21:30:25
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>(1 << nums.length);
    result.add(List.of());
    result.add(List.of(nums[0]));
    int size = result.size();
    int addSize = 1;
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      size = result.size();
      int index = 0;
      if (nums[i] == nums[i - 1]) {
        index = size - addSize;
      }
      addSize = 0;
      for (int j = index; j < size; j++) {
        List<Integer> next = new ArrayList<>(result.get(j));
        next.add(num);
        result.add(next);
        addSize++;
      }
    }
    return result;
  }
  // end::answer[]
}
