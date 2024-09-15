package com.diguage.algo.leetcode;

public class _0343_IntegerBreak_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 20:47:03
   */
  public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      int max = -1;
      for (int j = 1; j < i / 2 + 1; j++) {
        max = Math.max(Math.max(max, j * (i - j)), j * dp[i - j]);
      }
      dp[i] = max;
    }
    return dp[n];
  }
  // end::answer[]
}
