package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0629_KInversePairsArray_1b {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-09 20:22:16
   */
  public int kInversePairs(int n, int k) {
    int[][] memo = new int[n + 1][k + 1];
    for (int[] m : memo) {
      Arrays.fill(m, -1);
    }
    return dfs(n, k, memo);
  }

  private int dfs(int n, int k, int[][] memo) {
    if (k > n * (n - 1) / 2) {
      return 0;
    }
    if (n == 1) {
      return k == 0 ? 1 : 0;
    }
    if (memo[n][k] != -1) {
      return memo[n][k];
    }
    int MOD = 1_000_000_007;
    int result = 0;
    for (int i = Math.max(0, k - n + 1); i <= k; i++) {
      result += dfs(n - 1, i, memo) % MOD;
      result %= MOD;
    }
    return memo[n][k] = result;
  }
  // end::answer[]
}
