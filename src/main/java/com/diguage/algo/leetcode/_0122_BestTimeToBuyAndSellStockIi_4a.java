package com.diguage.algo.leetcode;

public class _0122_BestTimeToBuyAndSellStockIi_4a {
  // tag::answer[]
  /**
   * 暴力破解（198/202）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-17 15:56:56
   */
  public int maxProfit(int[] prices) {
    return dfs(prices, prices.length - 1, false);
  }

  private int dfs(int[] prices, int index, boolean hold) {
    if (index < 0) {
      if (hold) {
        return Integer.MIN_VALUE;
      } else {
        return 0;
      }
    }
    if (hold) {
      return Math.max(dfs(prices, index - 1, true),
        dfs(prices, index - 1, false) - prices[index]);
    }
    return Math.max(dfs(prices, index - 1, false),
      dfs(prices, index - 1, true) + prices[index]);
  }
  // end::answer[]
}
