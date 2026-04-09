package com.diguage.algo.leetcode;

public class _0629_KInversePairsArray_1a {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-09 19:55:53
   */
  public int kInversePairs(int n, int k) {
    return dfs(n, k);
  }

  private int dfs(int n, int k) {
    if (k > n * (n - 1) / 2) {
      return 0;
    }
    if (n == 1) {
      return k == 0 ? 1 : 0;
    }
    int MOD = 1_000_000_007;
    int result = 0;
    for (int i = Math.max(0, k - n + 1); i <= k; i++) {
      result += dfs(n - 1, i) % MOD;
      result %= MOD;
    }
    return result;
  }
  // end::answer[]
}
