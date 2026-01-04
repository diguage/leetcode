package com.diguage.algo.leetcode;

public class _1997_FirstDayWhereYouHaveBeenInAllTheRooms_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-04 19:34:45
   */
  public int firstDayBeenInAllRooms(int[] nextVisit) {
    final long MOD = 1_000_000_007;
    int n = nextVisit.length;
    long[] s = new long[n];
    for (int i = 0; i < n - 1; i++) {
      int j = nextVisit[i];
      s[i + 1] = (2 * s[i] - s[j] + 2 + MOD) % MOD;
    }
    return (int) s[n - 1];
  }
  // end::answer[]
}
