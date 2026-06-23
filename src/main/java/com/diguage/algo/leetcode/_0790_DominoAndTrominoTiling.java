package com.diguage.algo.leetcode;

public class _0790_DominoAndTrominoTiling {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-23 22:58:13
   */
  private static final int MOD = 1_000_000_007;

  public int numTilings(int n) {
    int[] memo = new int[n + 3];
    memo[1] = 1;
    memo[2] = 2;
    memo[3] = 5;
    return dfs(n, memo);
  }

  private int dfs(int n, int[] memo) {
    if (memo[n] > 0) {
      return memo[n];
    }
    long sum = 0L;
    sum += dfs(n - 3, memo);
    sum += 2L * dfs(n - 1, memo);
    return memo[n] = (int) (sum % MOD);
  }
  // end::answer[]

  static void main() {
    new _0790_DominoAndTrominoTiling().numTilings(60);
  }
}
