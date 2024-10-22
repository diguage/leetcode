package com.diguage.algo.leetcode;

public class _0474_OnesAndZeroes {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-10-22 19:47:11
   */
  public int findMaxForm(String[] strs, int m, int n) {
    int length = strs.length;
    int[][] bits = new int[2][length];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < strs[i].length(); j++) {
        char c = strs[i].charAt(j);
        bits[c - '0'][i]++;
      }
    }
    // 确定 dp 数组（dp table）以及下标的含义
    // dp 数组如何初始化
    int[][][] dp = new int[length + 1][m + 1][n + 1];
    // 确定遍历顺序
    for (int i = 1; i <= length; i++) {
      int zero = bits[0][i - 1];
      int one = bits[1][i - 1];
      for (int j = 0; j <= m; j++) {
        for (int k = 0; k <= n; k++) {
          // 确定递推公式
          dp[i][j][k] = dp[i - 1][j][k];
          if (j >= zero && k >= one) {
            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zero][k - one] + 1);
          }
        }
      }
    }
    return dp[length][m][n];
  }
  // end::answer[]
}
