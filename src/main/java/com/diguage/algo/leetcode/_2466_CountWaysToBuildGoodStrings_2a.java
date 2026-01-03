package com.diguage.algo.leetcode;

public class _2466_CountWaysToBuildGoodStrings_2a {
  // tag::answer[]

  /**
   * 暴力破解（14/36）->
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-03 10:05:29
   */
  public int countGoodStrings(int low, int high, int zero, int one) {
    int mod = 1_000_000_007;
    int result = 0;
    for (int i = low; i <= high; i++) {
      result += dfs(i, zero, one, mod);
      result %= mod;
    }
    return result;
  }

  private int dfs(int length, int zero, int one, int mod) {
    if (length == 0) {
      return 1;
    }
    int a = length >= zero ? dfs(length - zero, zero, one, mod) : 0;
    int b = length >= one ? dfs(length - one, zero, one, mod) : 0;
    return (a + b) % mod;
  }
  // end::answer[]
}
