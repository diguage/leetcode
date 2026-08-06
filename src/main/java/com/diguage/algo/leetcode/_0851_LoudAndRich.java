package com.diguage.algo.leetcode;

import java.util.*;

public class _0851_LoudAndRich {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-06 22:47:30
   */
  public int[] loudAndRich(int[][] richer, int[] quiet) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] r : richer) {
      int a = r[0];
      int b = r[1];
      graph.computeIfAbsent(b, _ -> new ArrayList<>()).add(a);
    }
    int n = quiet.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    for (int i = 0; i < n; i++) {
      dfs(graph, quiet, result, i);
    }
    return result;
  }

  // 未优化 通过 71 / 86 个测试用例 ->  23.68%
  private void dfs(Map<Integer, List<Integer>> graph,
                   int[] quiet, int[] result, int i) {
    if (result[i] != -1) {
      return;
    }
    result[i] = i;
    for (Integer n : graph.getOrDefault(i, Collections.emptyList())) {
      dfs(graph, quiet, result, n);
      if (quiet[result[n]] < quiet[result[i]]) {
        result[i] = result[n];
      }
    }
  }
  // end::answer[]

  static void main() {
    new _0851_LoudAndRich()
      .loudAndRich(new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}}, new int[]{3, 2, 5, 4, 6, 1, 7, 0});
  }

}
