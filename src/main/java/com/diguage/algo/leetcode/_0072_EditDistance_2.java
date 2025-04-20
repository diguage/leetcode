package com.diguage.algo.leetcode;

public class _0072_EditDistance_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-20 19:29:44
   */
  public int minDistance(String word1, String word2) {
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      dp[i][0] = i;
    }
    for (int i = 1; i <= n; i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          // 替换：dp[i][j] = dp[i-1][j-1] + 1
          // 删除：dp[i][j] = dp[i-1][j] + 1
          // 插入：dp[i][j] = dp[i][j-1] + 1
          // dp[i][j] = min{dp[i-1][j-1], dp[i][j-1], dp[i-1][j]} + 1
          int min = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
          dp[i][j] = min + 1;
        }
      }
    }
    return dp[m][n];
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0072_EditDistance_2().minDistance("horse", "ros");
  }
}
