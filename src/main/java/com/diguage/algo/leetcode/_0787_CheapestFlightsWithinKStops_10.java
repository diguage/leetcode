package com.diguage.algo.leetcode;

import java.util.*;

public class _0787_CheapestFlightsWithinKStops_10 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-06 21:30:38
   */
  final int MAX = 100 * 10000 + 1;

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> srcMap = new HashMap<>();
    for (int[] flight : flights) {
      int start = flight[0];
      srcMap.computeIfAbsent(start, x -> new ArrayList<>()).add(flight);
    }
    int[][] memo = new int[n][k + 1];
    int result = dfs(n, srcMap, src, dst, k + 1, memo);
    return result == MAX ? -1 : result;
  }

  private int dfs(int n, Map<Integer, List<int[]>> srcMap,
                  int src, int dst, int k, int[][] memo) {
    if (k < 0) {
      return MAX;
    }
    if (src == dst) {
      return 0;
    }
    if (memo[src][k] != 0) {
      return memo[src][k];
    }
    int result = MAX;
    for (int[] flight : srcMap.getOrDefault(src, Collections.emptyList())) {
      int idst = flight[1];
      int cost = flight[2];
      result = Math.min(result, dfs(n, srcMap, idst, dst, k - 1, memo) + cost);
    }
    memo[src][k] = result;
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0787_CheapestFlightsWithinKStops_10().findCheapestPrice(4,
      new int[][]{
        {0, 1, 100},
        {1, 2, 100},
        {2, 0, 100},
        {1, 3, 600},
        {2, 3, 200}}, 0, 3, 1);
  }
}
