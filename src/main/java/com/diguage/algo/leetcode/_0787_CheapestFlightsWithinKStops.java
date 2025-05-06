package com.diguage.algo.leetcode;

import java.util.*;

public class _0787_CheapestFlightsWithinKStops {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-06 18:53:25
   */
  int result = Integer.MAX_VALUE;

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> srcMap = new HashMap<>();
    for (int[] flight : flights) {
      int start = flight[0];
      srcMap.computeIfAbsent(start, x -> new ArrayList<>()).add(flight);
    }
    backtrack(n, srcMap, src, dst, k + 1, 0);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private void backtrack(int n, Map<Integer, List<int[]>> srcMap,
                         int src, int dst, int k, int expend) {

    if (k < 0) {
      return;
    }
    if (src == dst) {
      result = Math.min(result, expend);
      return;
    }
    for (int[] flight : srcMap.getOrDefault(src, Collections.emptyList())) {
      int idst = flight[1];
      int cost = flight[2];
      // 不加该判断，通过 28 / 56 个测试用例；加上，通过 48 / 56 个测试用例
      if (cost + expend >= result) {
        continue;
      }
      backtrack(n, srcMap, idst, dst, k - 1, cost + expend);
    }
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0787_CheapestFlightsWithinKStops().findCheapestPrice(4,
      new int[][]{
        {0, 1, 100},
        {1, 2, 100},
        {2, 0, 100},
        {1, 3, 600},
        {2, 3, 200}}, 0, 3, 1);
  }
}
