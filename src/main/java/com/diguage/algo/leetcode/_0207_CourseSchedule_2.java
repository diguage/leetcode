package com.diguage.algo.leetcode;

import java.util.*;

public class _0207_CourseSchedule_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-26 16:36
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegrees = new int[numCourses];
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] pres : prerequisites) {
      int pre = pres[1];
      int post = pres[0];
      indegrees[post]++;
      List<Integer> posts = graph.getOrDefault(pre, new ArrayList<>());
      posts.add(post);
      graph.put(pre, posts);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) {
        queue.offer(i);
      }
    }
    int cnt = 0;
    while (!queue.isEmpty()) {
      int course = queue.poll();
      cnt++;
      for (int c : graph.getOrDefault(course, Collections.emptyList())) {
        indegrees[c]--;
        if (indegrees[c] == 0) {
          queue.offer(c);
        }
      }
    }
    return cnt == numCourses;
  }
  // end::answer[]
}
