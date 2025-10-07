package com.diguage.algo.leetcode;

import java.util.Objects;

public class _1143_LongestCommonSubsequence_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-07 21:27:54
   */
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int r = 1; r <= m; r++) {
      for (int c = 1; c <= n; c++) {
        if (Objects.equals(text1.charAt(r - 1), text2.charAt(c - 1))) {
          dp[r][c] = dp[r - 1][c - 1] + 1;
        } else {
          dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
        }
      }
    }
    return dp[m][n];
  }

  // end::answer[]
  static void main() {
    new _1143_LongestCommonSubsequence_2()
      .longestCommonSubsequence("abcde", "ace");
  }
}
