package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040_CombinationSumII_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 17:31:07
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, result, 0, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] candidates, int target,
                         List<List<Integer>> result, int start, List<Integer> path) {
    if (target == 0) {
      result.add(new ArrayList(path));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      int num = candidates[i];
      if (target < num) {
        break;
      }
      if (start < i && candidates[i - 1] == candidates[i]) {
        continue;
      }
      path.add(num);
      backtrack(candidates, target - num, result, i + 1, path);
      path.remove(path.size() - 1);
    }
  }
  // end::answer[]
}
