package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0090_SubsetsIi_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-16 20:36:30
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>(1 << nums.length);
    result.add(List.of());
    result.add(List.of(nums[0]));
    int start = 1;
    for (int i = 1; i < nums.length; i++) {
      // 如果与前一个元素相同，则只需要处理上次添加的子集即可，否则处理全部已有子集
      if (nums[i - 1] != nums[i]) {
        start = 0;
      }
      int size = result.size();
      for (int j = start; j < size; j++) {
        List<Integer> adding = new ArrayList<>(result.get(j));
        adding.add(nums[i]);
        result.add(adding);
      }
      start = size;
    }
    return result;
  }
  // end::answer[]
}
