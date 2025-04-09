package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0046_Permutations_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-06 16:50
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }

  private void backtrack(int[] nums, List<List<Integer>> result,
                         List<Integer> path, boolean[] used) {
    if (path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      // 选择
      used[i] = true;
      path.add(nums[i]);
      backtrack(nums, result, path, used);
      // 撤销
      path.removeLast();
      used[i] = false;
    }
  }
  // end::answer[]
}
