package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1049_LastStoneWeightIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-24 16:12:19
   */
  public int lastStoneWeightII(int[] stones) {
    int sum = Arrays.stream(stones).sum();
    int n = stones.length, m = sum / 2;
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= m; j++) {
        if (j < stones[i]) {
          dp[i + 1][j] = dp[i][j];
        } else {
          dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]];
        }
      }
    }
    for (int i = m; i >= 0; i--) {
      if (dp[n][i]) {
        return sum - 2 * i;
      }
    }
    return sum;
  }
  // end::answer[]
}
