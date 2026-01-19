package com.diguage.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _0787_CheapestFlightsWithinKStops_2c {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-19 21:36:05
   */
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    final int MAX = 10000 * 101 + 1;
    int[][] dp = new int[k + 2][n];
    for (int[] ints : dp) {
      Arrays.fill(ints, MAX);
    }
    dp[0][src] = 0;
    for (int i = 1; i <= k + 1; i++) {
      for (int[] flight : flights) {
        int s = flight[0], d = flight[1], c = flight[2];
        dp[i][d] = Math.min(dp[i][d], dp[i - 1][s] + c);
      }
    }
    int result = MAX;
    for (int i = 1; i <= k + 1; i++) {
      result = Math.min(result, dp[i][dst]);
    }
    return result == MAX ? -1 : result;
  }
  // end::answer[]

  static void main() {
    new _0787_CheapestFlightsWithinKStops_2c()
//      .findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1);
      .findCheapestPrice(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {2, 0, 10}}, 1, 2, 1); // 这道题怎么会有 1 这个解呢？
  }
}
