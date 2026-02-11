package com.diguage.algo.leetcode;

import java.util.*;

public class _0310_MinimumHeightTrees_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-11 23:17:57
   */
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return Arrays.asList(0);
    }
    int[] degrees = new int[n];
    List<Integer>[] childrens = new List[n];
    for (int[] edge : edges) {
      int v1 = edge[0];
      int v2 = edge[1];
      degrees[v1]++;
      degrees[v2]++;
      if (childrens[v1] == null) {
        childrens[v1] = new ArrayList<>();
      }
      childrens[v1].add(v2);
      if (childrens[v2] == null) {
        childrens[v2] = new ArrayList<>();
      }
      childrens[v2].add(v1);
    }
    Queue<Integer> queue = new ArrayDeque<>();
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
        Integer v = queue.poll();
        result.add(v);
        for (Integer child : childrens[v]) {
          degrees[child]--;
          if (degrees[child] ==1) {
            queue.add(child);
          }
        }
      }
    }
    return result;
  }
  // end::answer[]
}
