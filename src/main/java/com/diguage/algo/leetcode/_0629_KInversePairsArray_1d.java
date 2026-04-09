package com.diguage.algo.leetcode;

public class _0629_KInversePairsArray_1d {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-09 20:35:42
   */
  public int kInversePairs(int n, int k) {
    // dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + ... + dp[i-1][j-i-1]
    // dp[i][j-1] =            dp[i-1][j-1] + ... + dp[i-1][j-1-(i-1-1)] + dp[i-1][j-1-i-1]
    // dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1-i-1]
    long[][] dp = new long[n + 1][k + 1];
    dp[1][0] = 1;
    int MOD = 1_000_000_007;
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= Math.min(k, i * (i - 1) / 2); j++) {
        // dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-i]
        // 奇怪：为啥这里要加 MOD ？
        dp[i][j] = (dp[i - 1][j] + (j >= 1 ? dp[i][j - 1] : 0)
          - (j >= i ? dp[i - 1][j - i] : 0) + MOD) % MOD;
      }
    }
    return (int) dp[n][k];
  }
  // end::answer[]
}
