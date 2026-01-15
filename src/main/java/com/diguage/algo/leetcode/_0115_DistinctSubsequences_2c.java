package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0115_DistinctSubsequences_2c {
  // tag::answer[]
  /**
   * 暴力破解（55/66） -> 备忘录（6.33%）-> 动态规划
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-15 19:44:24
   */
  public int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();
    int[][] dp = new int[n + 1][m + 1];
    Arrays.fill(dp[0], 1);
    char[] scs = s.toCharArray();
    char[] tcs = t.toCharArray();
    for (int ti = 1; ti <= n; ti++) {
      for (int si = ti; si <= m; si++) {
        dp[ti][si] = dp[ti][si - 1];
        if (scs[si - 1] == tcs[ti - 1]) {
          dp[ti][si] += dp[ti - 1][si - 1];
        }
      }
    }
    return dp[n][m];
  }
  // end::answer[]
  static void main() {
    new _0115_DistinctSubsequences_2c()
      .numDistinct("babgbag", "bag");
  }

}
