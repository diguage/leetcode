package com.diguage.algo.leetcode;

import java.util.*;

public class _0802_FindEventualSafeStates_2 {
  // tag::answer[]

  /**
   * 反向图 + 拓扑排序
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-30 22:03:48
   */
  public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer>[] reversed = new List[graph.length];
    int[] rinderess = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      int[] target = graph[i];
      rinderess[i] = target.length;
      for (int t : target) {
        if (Objects.isNull(reversed[t])) {
          reversed[t] = new ArrayList<>();
        }
        reversed[t].add(i);
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < rinderess.length; i++) {
      if (rinderess[i] == 0) {
        result.add(i);
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      if (Objects.isNull(reversed[node])) {
        continue;
      }
      for (int n : reversed[node]) {
        rinderess[n]--;
        if (rinderess[n] == 0) {
          queue.add(n);
          result.add(n);
        }
      }
    }
    Collections.sort(result);
    return result;
  }
  // end::answer[]
}
