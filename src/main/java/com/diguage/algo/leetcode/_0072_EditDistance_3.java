package com.diguage.algo.leetcode;

public class _0072_EditDistance_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-20 22:42:36
   */
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int r = 0; r <= n; r++) {
      dp[0][r] = r;
    }
    // 可以把这步和下面的循环合并，减少一次循环
    for (int c = 0; c <= m; c++) {
      dp[c][0] = c;
    }
    for (int c = 1; c <= m; c++) {
      for (int r = 1; r <= n; r++) {
        if (word1.charAt(c - 1) == word2.charAt(r - 1)) {
          dp[c][r] = dp[c - 1][r - 1];
        } else {
          int min = Math.min(dp[c][r - 1], dp[c - 1][r]);
          min = Math.min(min, dp[c - 1][r - 1]);
          dp[c][r] = min + 1;
        }
      }
    }
    return dp[m][n];
  }

  // end::answer[]
  static void main() {
    new _0072_EditDistance_3().minDistance("horse", "ros");
  }
}
