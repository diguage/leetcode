package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0046_Permutations_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 22:11:50
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrack(nums, result, used, new ArrayList(nums.length));
    return result;
  }

  private void backtrack(int[] nums, List<List<Integer>> result,
                         boolean[] used, List<Integer> path) {
    if (path.size() == nums.length) {
      result.add(new ArrayList(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      path.add(nums[i]);
      backtrack(nums, result, used, path);
      path.remove(path.size() - 1);
      used[i] = false;
    }
  }
  // end::answer[]
}
