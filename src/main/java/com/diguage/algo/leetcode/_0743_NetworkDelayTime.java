package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0743_NetworkDelayTime {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-04 22:26:14
   */
  public int networkDelayTime(int[][] times, int n, int k) {
    final int INF = Integer.MAX_VALUE / 2;
    int[][] graph = new int[n][n];
    for (int[] row : graph) {
      Arrays.fill(row, INF);
    }
    for (int[] t : times) {
      graph[t[0] - 1][t[1] - 1] = t[2];
    }
    int max = 0;
    int[] distances = new int[n];
    Arrays.fill(distances, INF);
    distances[k - 1] = 0;
    boolean[] done = new boolean[n];
    while (true) {
      int x = -1;
      for (int i = 0; i < n; i++) {
        if (!done[i] && (x < 0 || distances[i] < distances[x])) {
          x = i;
        }
      }
      if (x < 0) {
        return max; // 最后一次算出的最短路就是最大的
      }
      if (distances[x] == INF) { // 有节点无法到达
        return -1;
      }
      max = distances[x]; // 求出的最短路会越来越大
      done[x] = true; // 最短路长度已确定（无法变得更小）
      for (int y = 0; y < n; y++) {
        distances[y] = Math.min(distances[y], distances[x] + graph[x][y]);
      }
    }
  }
  // end::answer[]

  static void main() {
    new _0743_NetworkDelayTime().networkDelayTime(new int[][]{new int[]{2, 1, 1},
      new int[]{2, 3, 1}, new int[]{3, 4, 1}}, 4, 2);
  }
}
