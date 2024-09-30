package com.diguage.algo.leetcode;

public class _0072_EditDistance {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-30 17:32:45
   */
  public int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    // 1. 确定 dp[i][j] 含义
    int[][] dp = new int[len1 + 1][len2 + 1];
    // 3. 初始化基本状态
    for (int i = 0; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= len2; i++) {
      dp[0][i] = i;
    }
    // 确定遍历过程
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        // 2. 确定转移方程
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          // 删除操作：dp[i - 1][j]
          // 增加操作：dp[i][j - 1]
          // 替换操作：dp[i - 1][j - 1]
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
            dp[i - 1][j - 1]) + 1;
        }
      }
    }
    return dp[len1][len2];
  }
  // end::answer[]
}
