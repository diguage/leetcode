package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 77. Combinations
 *
 * https://leetcode.com/problems/combinations/[Combinations - LeetCode]
 *
 */
public class _0077_Combinations_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-09 15:52:37
   */
  public List<List<Integer>> combine(int n, int k) {
    if (k <= 0 || n < k) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    backtrack(n, k, 1, result, new LinkedList<>());
    return result;
  }

  private void backtrack(int n, int k, int start,
                         List<List<Integer>> result, List<Integer> com) {
    if (com.size() == k) {
      result.add(new ArrayList<>(com));
      // 剪枝，已经符合要求就无需再向下走
      return;
    }
    for (int i = start; i <= n; i++) {
      // 剪枝，已经无法满足条件的路径直接剪掉
      if (com.size() + (n - i + 1) < k) {
        break;
      }
      com.add(i);
      backtrack(n, i + 1, k, result, com);
      com.remove(com.size() - 1);
    }
  }
  // end::answer[]
}
