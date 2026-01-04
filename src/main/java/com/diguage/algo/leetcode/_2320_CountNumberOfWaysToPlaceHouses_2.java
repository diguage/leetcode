package com.diguage.algo.leetcode;

public class _2320_CountNumberOfWaysToPlaceHouses_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-04 21:26:56
   */
  public int countHousePlacements(int n) {
    if (n == 1) {
      return 4;
    }
    if (n == 2) {
      return 9;
    }
    final long MOD = 1_000_000_007;
    long a = 2, b = 3;
    for (int i = 3; i <= n; i++) {
      long tmp = (a + b) % MOD;
      a = b;
      b = tmp;
    }
    return (int) ((b * b) % MOD);
  }
  // end::answer[]
}
