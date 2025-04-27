package com.diguage.algo.leetcode;

public class _0122_BestTimeToBuyAndSellStockIi_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-27 07:59:27
   */
  public int maxProfit(int[] prices) {
    int result = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i - 1] < prices[i]) {
        // 见好就收
        result += prices[i] - prices[i - 1];
      }
    }
    return result;
  }
  // end::answer[]
}
