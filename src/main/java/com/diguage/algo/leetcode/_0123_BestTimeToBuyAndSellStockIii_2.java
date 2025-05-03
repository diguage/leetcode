package com.diguage.algo.leetcode;

public class _0123_BestTimeToBuyAndSellStockIii_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-27 09:02:36
   */
  public int maxProfit(int[] prices) {
    // prices x
    // 交易次数 y
    // 买、卖、不动 买0，卖则为1
    // dp[x][y][z]
    // dp[x][y][0] = max{dp[x-1][y][0], dp[x-1][y][1]+price[x]}
    // dp[x][y][1] = max{dp[x-1][y][1], dp[x-1][y-1][0]-price[x]}
    int maxK = 2;
    int[][][] dp = new int[prices.length][maxK + 1][2];
    for (int x = 0; x < prices.length; x++) {
      for (int y = maxK; y >= 1; y--) {
        if (x == 0) {
          dp[x][y][0] = 0;
          dp[x][y][1] = -prices[x];
          continue;
        }
        dp[x][y][0] = Math.max(dp[x - 1][y][0], dp[x - 1][y][1] + prices[x]);
        dp[x][y][1] = Math.max(dp[x - 1][y][1], dp[x - 1][y - 1][0] - prices[x]);
      }
    }
    return dp[prices.length - 1][maxK][0];
  }
  // end::answer[]
}
