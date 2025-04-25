package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040_CombinationSumIi_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 17:31:07
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
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
      // 已经超量了，则直接返回
      if (num > target) {
        return;
      }
      // 同一层，相同的数字只能选一次。否则，就会产生重复的组合。
      if (i > index && candidates[i - 1] == candidates[i]) {
        continue;
      }
      path.add(num);
      backtrack(candidates, target - num, result, path, i + 1);
      path.removeLast();
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0040_CombinationSumIi_4()
      .combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
  }
}
