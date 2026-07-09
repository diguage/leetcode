package com.diguage.algo.leetcode;

import java.util.*;

public class _0815_BusRoutes {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-09 21:20:17
   */
  public int numBusesToDestination(int[][] routes, int source, int target) {
    // 记录经过车站 x 的公交车编号
    Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
    for (int i = 0; i < routes.length; i++) {
      for (int x : routes[i]) {
        stopToBuses.computeIfAbsent(x, _ -> new ArrayList<>()).add(i);
      }
    }
    // 小优化：如果没有公交车经过起点或终点，直接返回
    if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) {
      return source != target ? -1 : 0;
    }
    // BFS
    Map<Integer, Integer> dis = new HashMap<>();
    dis.put(source, 0);
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(source);
    while (!queue.isEmpty()) {
      Integer x = queue.poll();
      Integer disX = dis.get(x);
      for (Integer i : stopToBuses.get(x)) {
        if (routes[i] != null) {
          for (int y : routes[i]) {
            if (!dis.containsKey(y)) {
              dis.put(y, disX + 1);
              queue.add(y);
            }
          }
          routes[i] = null;
        }
      }
    }
    return dis.getOrDefault(target, -1);
  }
  // end::answer[]

  static void main() {
    new _0815_BusRoutes()
      .numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
  }
}
