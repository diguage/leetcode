package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0122_BestTimeToBuyAndSellStockIi_4c {
  // tag::answer[]
  /**
   * 暴力破解（198/202）-> 备忘录（5.16%）-> 动态规划（43.37%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-17 16:20:14
   */
  public int maxProfit(int[] prices) {
    int[][] dp = new int[2][prices.length + 1];
    Arrays.fill(dp[0], 0);
    Arrays.fill(dp[1], Integer.MIN_VALUE);
    for (int i = 1; i <= prices.length; i++) {
      // dp[0][index] = max(dp[0][index-1], dp[1][index] + prices[index])
      // dp[1][index] = max(dp[0][index-1], dp[0][index] - prices[index])
      dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i - 1]);
      dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i - 1]);
    }
    return dp[0][prices.length];
  }

  // end::answer[]
  static void main() {
    new _0122_BestTimeToBuyAndSellStockIi_4c()
      .maxProfit(new int[]{7, 1, 5, 3, 6, 4});
  }
}
