package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0834_SumOfDistancesInTree {
  // tag::answer[]

  /**
   * DFS： 64 / 74 超时
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-23 21:52:43
   */
  int distance = 0;

  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      distance = 0;
      dfs(i, graph, 0, new HashSet<>());
      result[i] = distance;
    }
    return result;
  }

  private void dfs(int i, List<Integer>[] graph,
                   int levle, Set<Integer> used) {
    if (used.contains(i)) {
      return;
    }
    used.add(i);
    distance += levle;
    Set<Integer> nodes = new HashSet<>(graph[i]);
    nodes.removeAll(used);
    if (nodes.isEmpty()) {
      return;
    }
    for (Integer node : nodes) {
      dfs(node, graph, levle + 1, used);
    }
  }
  // end::answer[]

  static void main() {
    new _0834_SumOfDistancesInTree()
      .sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
  }
}
