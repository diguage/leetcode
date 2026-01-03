package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _2466_CountWaysToBuildGoodStrings_2b {
  // tag::answer[]

  /**
   * 暴力破解（14/36）-> 备忘录（12.65%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-03 10:20:23
   */
  public int countGoodStrings(int low, int high, int zero, int one) {
    int mod = 1_000_000_007;
    int[] memo = new int[high + 1];
    Arrays.fill(memo, -1);
    int result = 0;
    for (int i = low; i <= high; i++) {
      result += dfs(i, zero, one, mod, memo);
      result %= mod;
    }
    return result;
  }

  private int dfs(int length, int zero, int one, int mod, int[] memo) {
    if (length == 0) {
      return 1;
    }
    if (memo[length] >= 0) {
      return memo[length];
    }
    // f(i) = f(i-zero) + f(i-one)
    int a = length >= zero ? dfs(length - zero, zero, one, mod, memo) : 0;
    int b = length >= one ? dfs(length - one, zero, one, mod, memo) : 0;
    return memo[length] = (a + b) % mod;
  }
  // end::answer[]
}
