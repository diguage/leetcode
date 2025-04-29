package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0216_CombinationSumIii {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-30 07:16:18
   */
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>(k);
    backtrack(k, n, result, path, 1);
    return result;
  }

  private void backtrack(int count, int sum,
                         List<List<Integer>> result,
                         List<Integer> path, int start) {
    if (path.size() > count) {
      return;
    }
    if (sum == 0 && path.size() == count) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = start; i <= 9; i++) {
      if (i > sum) {
        break;
      }
      path.add(i);
      backtrack(count, sum - i, result, path, i + 1);
      path.removeLast();
    }
  }
  // end::answer[]
}
