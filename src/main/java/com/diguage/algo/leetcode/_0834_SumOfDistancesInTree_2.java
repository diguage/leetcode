package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0834_SumOfDistancesInTree_2 {
  // tag::answer[]

  /**
   * DFS： 64 / 74 超时 -> 换根 DP
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-26 20:52:27
   */
  private List<Integer>[] graph;
  private int[] result;
  private int[] size;

  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    graph = new ArrayList[n];
    Arrays.setAll(graph, e -> new ArrayList<>());
    for (int[] e : edges) {
      int x = e[0];
      int y = e[1];
      graph[x].add(y);
      graph[y].add(x);
    }
    result = new int[n];
    size = new int[n];
    dfs(0, -1, 0);
    reroot(0, -1);
    return result;
  }

  private void dfs(int x, int parent, int depth) {
    result[0] += depth;
    size[x] = 1;
    for (Integer y : graph[x]) {
      // 非常巧妙！无法向上遍历，就可以避免重复遍历
      if (y == parent) {
        continue;
      }
      dfs(y, x, depth + 1);
      size[x] += size[y];
    }
  }

  private void reroot(int x, int parent) {
    for (Integer y : graph[x]) {
      if (y == parent) {
        continue;
      }
      result[y] = result[x] + graph.length - 2 * size[y];
      reroot(y, x);
    }
  }

  // end::answer[]
}
