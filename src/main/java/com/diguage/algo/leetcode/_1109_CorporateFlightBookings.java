package com.diguage.algo.leetcode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-05 15:17:57
 */
public class _1109_CorporateFlightBookings {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-05 15:17:57
   */
  public int[] corpFlightBookings(int[][] bookings, int n) {
    if (bookings == null || bookings.length == 0) {
      return new int[n];
    }
    int[] flights = new int[n];
    for (int[] book : bookings) {
      int start = book[0] - 1;
      int end = book[1];
      int val = book[2];
      flights[start] += val;
      if (end < n) {
        flights[end] -= val;
      }
    }
    for (int i = 1; i < n; i++) {
      flights[i] += flights[i - 1];
    }
    return flights;
  }
  // end::answer[]
}
