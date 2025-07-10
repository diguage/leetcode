package com.diguage.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _0310_MinimumHeightTrees {
  // tag::answer[]
  /**
   * 深度优先遍历，通过 68 / 71 测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-10 17:37:37
   */
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
      graph.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
    }
    Map<Integer, List<Integer>> result = new HashMap<>();
    int min = Integer.MAX_VALUE;
    Map<String, Integer> memo = new HashMap<>();
    for (int root = 0; root < n; root++) {
      Set<Integer> path = new HashSet<>();
      int heigh = dfs(graph, root, path, memo);
      result.computeIfAbsent(heigh, val -> new ArrayList<>()).add(root);
      min = Math.min(min, heigh);
    }
    return result.get(min);
  }

  private int dfs(Map<Integer, List<Integer>> graph, Integer root,
                  Set<Integer> path, Map<String, Integer> memo) {
    Set<Integer> nexts = graph.getOrDefault(root, Collections.emptyList()).stream()
      .filter(v -> !path.contains(v))
      .collect(Collectors.toSet());
    if (nexts.isEmpty()) {
      return 0;
    }
    path.add(root);
    int max = Integer.MIN_VALUE;
    for (Integer next : nexts) {
      String key = root + "/" + next;
      int heigh;
      if (memo.containsKey(key)) {
        heigh = memo.get(key);
      } else {
        heigh = dfs(graph, next, path, memo);
        memo.put(key, heigh);
      }
      max = Math.max(max, heigh);
    }
    return max + 1;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0310_MinimumHeightTrees().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
//    new _0310_MinimumHeightTrees().findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
  }
}
