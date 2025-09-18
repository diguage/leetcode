package com.diguage.algo.leetcode;

import java.util.*;

public class _2316_CountUnreachablePairsOfNodesInAnUndirectedGraph {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-21 17:39:01
   */
  public long countPairs(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];
      graph.computeIfAbsent(a, k -> new HashSet<>()).add(b);
      graph.computeIfAbsent(b, k -> new HashSet<>()).add(a);
    }
    boolean[] visited = new boolean[n];
    long result = 0;
    for (int i = 0, total = 0; i < n; i++) {
      if (!visited[i]) {
        int size = dfs(i, graph, visited);
        result += 1L * size * total;
        total += size;
      }
    }
    return result;
  }

  private int dfs(int i, Map<Integer, Set<Integer>> graph, boolean[] visited) {
    visited[i] = true;
    int result = 1;
    for (Integer n : graph.getOrDefault(i, Collections.emptySet())) {
      if (!visited[n]) {
        result += dfs(n, graph, visited);
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _2316_CountUnreachablePairsOfNodesInAnUndirectedGraph()
//      .countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}});
      .countPairs(16, new int[][]{{0, 15}, {1, 14}, {2, 11}, {4, 3}, {5, 15}, {8, 2}, {14, 12}});
  }
}
