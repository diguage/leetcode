package com.diguage.algo.leetcode;

public class _0629_KInversePairsArray_1c {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-09 20:25:24
   */
  public int kInversePairs(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    dp[1][0] = 1;
    int MOD = 1_000_000_007;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= Math.min(k, i * (i - 1) / 2); j++) {
        for (int l = Math.max(0, j - i + 1); l <= j; l++) {
          dp[i][j] = (dp[i][j] + dp[i - 1][l]) % MOD;
        }
      }
    }
    return dp[n][k];
  }
  // end::answer[]
}
