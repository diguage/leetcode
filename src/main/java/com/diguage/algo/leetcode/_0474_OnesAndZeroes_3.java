package com.diguage.algo.leetcode;

public class _0474_OnesAndZeroes_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-16 22:41:12
   */
  public int findMaxForm(String[] strs, int m, int n) {
    int[][] bits = new int[strs.length][2];
    for (int i = 0; i < strs.length; i++) {
      String str = strs[i];
      for (char c : str.toCharArray()) {
        bits[i][c - '0']++;
      }
    }
    int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
    for (int x = 1; x <= strs.length; x++) {
      int zero = bits[x - 1][0];
      int one = bits[x - 1][1];
      for (int y = 0; y <= m; y++) {
        for (int z = 0; z <= n; z++) {
          if (y >= zero && z >= one) {
            dp[x][y][z] = Math.max(dp[x - 1][y][z], dp[x - 1][y - zero][z - one] + 1);
          } else {
            dp[x][y][z] = dp[x - 1][y][z];
          }
        }
      }
    }
    return dp[strs.length][m][n];
  }
  // end::answer[]
}
