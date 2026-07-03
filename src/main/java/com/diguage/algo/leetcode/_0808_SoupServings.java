package com.diguage.algo.leetcode;

public class _0808_SoupServings {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-03 22:51:51
   */
  public double soupServings(int n) {
    if (n >= 4451) {
      return 1;
    }
    n = (n + 24) / 25;
    double[][] memo = new double[n + 1][n + 1];
    return dfs(n, n, memo);
  }

  private double dfs(int a, int b, double[][] memo) {
    if (a <= 0 && b <= 0) {
      return 0.5D;
    }
    if (a <= 0) {
      return 1;
    }
    if (b <= 0) {
      return 0;
    }
    if (memo[a][b] != 0) {
      return memo[a][b];
    }
    return memo[a][b] = (dfs(a - 4, b, memo) + dfs(a - 3, b - 1, memo)
      + dfs(a - 2, b - 2, memo) + dfs(a - 1, b - 3, memo)) / 4;
  }
  // end::answer[]
}
