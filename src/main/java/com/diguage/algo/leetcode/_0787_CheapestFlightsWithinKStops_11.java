package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0787_CheapestFlightsWithinKStops_11 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-06 21:40:38
   */
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    final int MAX = 100 * 10000 + 1;
    int[][] dp = new int[k + 2][n];
    for (int i = 0; i < k + 2; i++) {
      Arrays.fill(dp[i], MAX);
    }
    dp[0][src] = 0;
    for (int i = 1; i < k + 2; i++) {
      for (int[] flight : flights) {
        int start = flight[0];
        int end = flight[1];
        int cost = flight[2];
        dp[i][end] = Math.min(dp[i][end], dp[i - 1][start] + cost);
      }
    }
    int result = MAX;
    for (int i = 1; i < k + 2; i++) {
      result = Math.min(result, dp[i][dst]);
    }
    return result == MAX ? -1 : result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0787_CheapestFlightsWithinKStops_11().findCheapestPrice(4,
      new int[][]{
        {0, 1, 100},
        {1, 2, 100},
        {2, 0, 100},
        {1, 3, 600},
        {2, 3, 200}}, 0, 3, 1);
  }
}
