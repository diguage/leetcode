package com.diguage.algo.leetcode;

import java.util.*;

public class _0207_CourseSchedule_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-04 09:09:52
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegree = new int[numCourses];
    for (int[] p : prerequisites) {
      List<Integer> children = graph.computeIfAbsent(p[0], k -> new ArrayList<>());
      children.add(p[1]);
      indegree[p[1]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < indegree.length; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    int cnt = 0;
    while (!queue.isEmpty()) {
      Integer c = queue.poll();
      cnt++;
      List<Integer> children = graph.getOrDefault(c, Collections.emptyList());
      for (Integer child : children) {
        indegree[child]--;
        if (indegree[child] == 0) {
          queue.offer(child);
        }
      }
    }
    return cnt == numCourses;
  }
  // end::answer[]
}
