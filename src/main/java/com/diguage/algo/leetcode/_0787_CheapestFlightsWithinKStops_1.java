package com.diguage.algo.leetcode;

public class _0787_CheapestFlightsWithinKStops_1 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-06 19:30:49
   */
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    return 0; // TODO
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0787_CheapestFlightsWithinKStops_1().findCheapestPrice(4,
      new int[][]{
        {0, 1, 100},
        {1, 2, 100},
        {2, 0, 100},
        {1, 3, 600},
        {2, 3, 200}}, 0, 3, 1);
  }
}
