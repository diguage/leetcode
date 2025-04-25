package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0039_CombinationSum_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-25 16:05:09
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>(candidates.length);
    backtrack(candidates, target, result, path, 0);
    return result;
  }

  private void backtrack(int[] candidates, int target,
                         List<List<Integer>> result,
                         List<Integer> path, int index) {
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      int num = candidates[i];
      if (num > target) {
        return;
      }
      path.add(num);
      backtrack(candidates, target - num, result, path, i);
      path.removeLast();
    }
  }
  // end::answer[]
}
