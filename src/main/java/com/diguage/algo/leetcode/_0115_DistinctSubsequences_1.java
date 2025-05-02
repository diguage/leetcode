package com.diguage.algo.leetcode;

public class _0115_DistinctSubsequences_1 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-02 22:07:01
   */
  public int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    if (m < n) {
      return 0;
    }
    // dp[i][j] 在 s[0..i] 中可以匹配多少个 t[0..j]
    int[][] dp = new int[m + 1][n + 1];
    // 在 t 的长度为 0 时，需要删除所有 s 才能匹配一个 t
    for (int i = 0; i <= m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= m; i++) {
      // 之所以 j <= i，是因为，如果 t 的长度大于 s，则必然没有子序列
      for (int j = 1; j <= i && j <= n; j++) {
        // 如果 s[i] != t[j]，那么只能在 s[i-1] 中查找 t[j]
        dp[i][j] = dp[i - 1][j];
        // 如果 s[i] == t[j]，则 可以在 s[i] 和 s[i-1] 中查找 t[j]
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] += dp[i - 1][j - 1];
        }
      }
    }
    return dp[m][n];
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0115_DistinctSubsequences_1()
      .numDistinct("rabbbit", "rabbit");
  }
}
