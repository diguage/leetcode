package com.diguage.algo.leetcode;

public class _1143_LongestCommonSubsequence_3c {
  // tag::answer[]

  /**
   * 暴力破解（18/47）→ 备忘录（5.67%）→ 动态规划（87.84%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-30 20:37:06
   */
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    char[] ac = text1.toCharArray();
    char[] bc = text2.toCharArray();
    for (int i = 0; i < text1.length(); i++) {
      for (int j = 0; j < text2.length(); j++) {
        if (ac[i] == bc[j]) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
      }
    }
    return dp[text1.length()][text2.length()];
  }
  // end::answer[]
}
