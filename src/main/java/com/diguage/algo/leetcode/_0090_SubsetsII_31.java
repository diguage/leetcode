package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0090_SubsetsII_31 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-10 11:38:25
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    int length = nums.length;
    List<List<Integer>> result = new ArrayList<>((int) Math.pow(2, length));
    result.add(new ArrayList<>());
    int start = 0;
    Integer prev = null;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int size = result.size();
      int j = 0;
      // 如果与前一个元素相同，则只需要处理上次添加的子集即可
      if (prev != null && num == prev) {
        j = start;
      }
      for (; j < size; j++) {
        List<Integer> subset = result.get(j);
        List<Integer> ns = new ArrayList<>(subset);
        ns.add(num);
        result.add(ns);
      }
      prev = num;
      start = size;
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0090_SubsetsII_31().subsetsWithDup(new int[]{1, 2, 2});
  }
}
