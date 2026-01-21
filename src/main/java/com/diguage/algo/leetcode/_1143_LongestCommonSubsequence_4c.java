package com.diguage.algo.leetcode;

public class _1143_LongestCommonSubsequence_4c {
  // tag::answer[]
  /**
   * 暴力破解（15/47）-> 备忘录（5.83%）-> 动态规划（56.13%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-21 17:42:17
   */
  public int longestCommonSubsequence(String a, String b) {
    int[][] dp = new int[a.length() + 1][b.length() + 1];
    char[] ac = a.toCharArray();
    char[] bc = b.toCharArray();
    for (int ai = 1; ai <= a.length(); ai++) {
      for (int bi = 1; bi <= b.length(); bi++) {
        // dp[ai][bi] = math(dp[ai-1][bi], dp[ai][bi-1])
        // dp[ai][bi] = math(dp[ai][bi], dp[ai-1][bi-1]+1)
        dp[ai][bi] = Math.max(dp[ai - 1][bi], dp[ai][bi - 1]);
        if (ac[ai - 1] == bc[bi - 1]) {
          dp[ai][bi] = Math.max(dp[ai][bi], dp[ai - 1][bi - 1] + 1);
        }
      }
    }
    return dp[a.length()][b.length()];
  }
  // end::answer[]

  static void main() {
    new _1143_LongestCommonSubsequence_4c()
      .longestCommonSubsequence("abcde", "ace");
  }
}
