package com.diguage.algo.leetcode;

import java.util.*;

public class _0310_MinimumHeightTrees {
  // tag::answer[]

  /**
   * 优化后：使用广度优先搜索，从外向内聚拢，中间节点才能生成最小高度树。
   *
   * 优化前：深度优先遍历，通过 68 / 71 测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-10 17:37:37
   */
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return Arrays.asList(0);
    }
    int[] degrees = new int[n];
    List<Integer>[] children = new List[n];
    for (int[] edge : edges) {
      degrees[edge[0]]++;
      degrees[edge[1]]++;
      if (children[edge[0]] == null) {
        children[edge[0]] = new ArrayList<>();
      }
      children[edge[0]].add(edge[1]);
      if (children[edge[1]] == null) {
        children[edge[1]] = new ArrayList<>();
      }
      children[edge[1]].add(edge[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (degrees[i] == 1) {
        queue.add(i);
      }
    }
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      result = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        result.add(cur);
        List<Integer> child = children[cur];
        for (Integer node : child) {
          degrees[node]--;
          if (degrees[node] == 1) {
            queue.add(node);
          }
        }
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0310_MinimumHeightTrees().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
//    new _0310_MinimumHeightTrees().findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
  }
}
