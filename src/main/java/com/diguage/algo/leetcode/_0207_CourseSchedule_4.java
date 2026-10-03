package com.diguage.algo.leetcode;

import java.util.*;

public class _0207_CourseSchedule_4 {

  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-03 22:00:00
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] p : prerequisites) {
      int a = p[1];
      int b = p[0];
      indegree[b]++;
      graph.computeIfAbsent(a, _ -> new ArrayList<>()).add(b);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }
    if (queue.isEmpty()) {
      return false;
    }
    while (!queue.isEmpty()) {
      Integer i = queue.poll();
      List<Integer> list = graph.getOrDefault(i, Collections.emptyList());
      for (Integer to : list) {
        indegree[to]--;
        if (indegree[to] == 0) {
          queue.add(to);
        }
      }
    }
    for (int i : indegree) {
      if (i > 0) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
}
