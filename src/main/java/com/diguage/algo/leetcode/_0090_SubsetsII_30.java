package com.diguage.algo.leetcode;

import java.util.*;

public class _0090_SubsetsII_30 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-09 18:04:54
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    result.add(new ArrayList<>());
    // 使用 Set 记录已添加的子集，这个方案还需要再优化
    Set<String> existed = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int size = result.size();
      for (int j = 0; j < size; j++) {
        List<Integer> subset = new ArrayList<>(result.get(j));
        subset.add(num);
        StringBuilder sb = new StringBuilder(nums.length);
        for (Integer ai : subset) {
          sb.append(ai);
        }
        if (existed.add(sb.toString())) {
          result.add(subset);
        }
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0090_SubsetsII_30().subsetsWithDup(new int[]{1, 2, 2});
  }
}
