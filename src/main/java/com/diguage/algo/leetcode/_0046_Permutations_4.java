package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0046_Permutations_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 22:11:50
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }

  private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> added, boolean[] used) {
    if (added.size() == nums.length) {
      result.add(new ArrayList<>(added));
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      added.add(nums[i]);
      backtrack(nums, result, added, used);
      used[i] = false;
      added.remove(added.size() - 1);
    }
  }
  // end::answer[]
}
