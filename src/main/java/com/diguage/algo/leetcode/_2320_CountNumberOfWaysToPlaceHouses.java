package com.diguage.algo.leetcode;

public class _2320_CountNumberOfWaysToPlaceHouses {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-11 19:24:20
   */
  public int countHousePlacements(int n) {
    long a = 1, b = 2;
    long cnt = b;
    for (int i = 2; i <= n; i++) {
      cnt = (a + b) % 1_000_000_007;
      a = b;
      b = cnt;
    }
    return (int) ((cnt * cnt) % 1_000_000_007);
  }
  // end::answer[]
  public static void main(String[] args) {
    new _2320_CountNumberOfWaysToPlaceHouses()
      .countHousePlacements(1000);
  }
}
