package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0039_CombinationSum_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-26 20:18:51
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(candidates, target, result, 0, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] candidates, int target,
                         List<List<Integer>> result, int index, List<Integer> path) {
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      int can = candidates[i];
      if (can > target) {
        return;
      }
      path.add(can);
      backtrack(candidates, target - can, result, i, path);
      path.removeLast();
    }
  }
  // end::answer[]
}
