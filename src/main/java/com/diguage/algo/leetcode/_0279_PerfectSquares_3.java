package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0279_PerfectSquares_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-24 22:47:40
   */
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n + 1);
    dp[0] = 0;
    for (int i = 1; i * i <= n; i++) {
      for (int j = i * i; j <= n; j++) {
        dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
      }
    }
    return dp[n];
  }
  // end::answer[]
}
