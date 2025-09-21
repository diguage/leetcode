package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1557_MinimumNumberOfVerticesToReachAllNodes {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-21 22:52:32
   */
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    int[] inDegrees = new int[n];
    for (List<Integer> edge : edges) {
      Integer out = edge.getLast();
      inDegrees[out]++;
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (inDegrees[i] == 0) {
        result.add(i);
      }
    }
    return result;
  }
  // end::answer[]
}
