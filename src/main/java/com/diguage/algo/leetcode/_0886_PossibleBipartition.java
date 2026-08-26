package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0886_PossibleBipartition {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-26 23:25:17
   */
  public boolean possibleBipartition(int n, int[][] dislikes) {
    List<Integer>[] graph = new ArrayList[n];
    Arrays.setAll(graph, k -> new ArrayList<>());
    for (int[] d : dislikes) {
      int x = d[0] - 1;
      int y = d[1] - 1;
      graph[x].add(y);
      graph[y].add(x);
    }
    return isBipartite(graph);
  }

  private boolean isBipartite(List<Integer>[] graph) {
    // colors[i] = 0  表示未访问节点 i
    // colors[i] = 1  表示节点 i 为红色
    // colors[i] = -1 表示节点 i 为蓝色
    int[] colors = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (colors[i] == 0 && !dfs(i, 1, graph, colors)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(int x, int c, List<Integer>[] graph, int[] colors) {
    colors[x] = c;
    for (Integer y : graph[x]) {
      if (colors[y] == c ||
        colors[y] == 0 && !dfs(y, -c, graph, colors)) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
}
