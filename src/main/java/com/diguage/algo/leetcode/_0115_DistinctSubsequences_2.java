package com.diguage.algo.leetcode;

public class _0115_DistinctSubsequences_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-14 20:21:39
   */
  public int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();
    int[][] dp = new int[m + 1][n + 1];
    // 当 t 的长度为 0 时，则只有一种组成方式
    for (int i = 0; i <= m; i++) {
      dp[i][0] = 1;
    }
    char[] tcs = t.toCharArray();
    char[] scs = s.toCharArray();
    for (int ti = 1; ti <= n; ti++) {
      char tc = tcs[ti - 1];
      for (int si = 1; si <= m; si++) {
        char sc = scs[si - 1];
        dp[si][ti] = dp[si - 1][ti];
        if (tc == sc) {
          dp[si][ti] += dp[si - 1][ti - 1];
        }
      }
    }
    return dp[m][n];
  }
  // end::answer[]

  static void main() {
    new _0115_DistinctSubsequences_2()
//      .numDistinct("rabbbit", "rabbit");
      .numDistinct("babgbag", "bag");
  }
}
