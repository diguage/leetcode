package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0279_PerfectSquares_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-19 22:06:00
   */
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n + 1);
    dp[0] = 0;
    // 外层遍历物品
    for (int i = 1; i * i <= n; i++) {
      // 内层遍历体积
      for (int j = i * i; j <= n; j++) {
        dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
      }
    }
    return dp[n];
  }
  // end::answer[]
  static void main() {
    new _0279_PerfectSquares_2().numSquares(43);
  }
}
