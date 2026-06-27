package com.diguage.algo.leetcode;

import java.util.*;

public class _0797_AllPathsFromSourceToTarget {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-27 21:54:33
   */
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<List<Integer>> queue = new LinkedList<>();
    for (int i : graph[0]) {
      if (i == graph.length - 1) {
        result.add(List.of(0, i));
      } else {
        queue.add(List.of(0, i));
      }
    }
    while (!queue.isEmpty()) {
      List<Integer> cur = queue.poll();
      int[] ints = graph[cur.getLast()];
      if (Objects.isNull(ints)) {
        continue;
      }
      for (int n : ints) {
        List<Integer> next = new ArrayList<>(cur);
        next.add(n);
        if (n == graph.length - 1) {
          result.add(next);
        } else {
          queue.offer(next);
        }
      }
    }
    return result;
  }
  // end::answer[]
}
