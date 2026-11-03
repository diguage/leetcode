package com.diguage.algo.leetcode;

import java.util.Objects;

public class _0072_EditDistance_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-03 22:24:12
   */
  public int minDistance(String word1, String word2) {
    if (Objects.isNull(word1) || word1.isEmpty()) {
      if (Objects.isNull(word2)) {
        return 0;
      } else {
        return word2.length();
      }
    }
    if (Objects.isNull(word2) || word2.isEmpty()) {
      return word1.length();
    }
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int c = 1; c <= word2.length(); c++) {
      dp[0][c] = c;
    }
    for (int r = 1; r <= word1.length(); r++) {
      dp[r][0] = r;
    }
    for (int r = 1; r <= word1.length(); r++) {
      for (int c = 1; c <= word2.length(); c++) {
        dp[r][c] = Math.min(dp[r - 1][c - 1] + 1, Math.min(dp[r - 1][c] + 1, dp[r][c - 1] + 1));
        if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
          dp[r][c] = Math.min(dp[r][c], dp[r - 1][c - 1]);
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }
  // end::answer[]
}
