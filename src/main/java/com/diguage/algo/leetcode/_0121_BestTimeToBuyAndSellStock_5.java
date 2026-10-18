package com.diguage.algo.leetcode;

public class _0121_BestTimeToBuyAndSellStock_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-04 10:55
   */
  public int maxProfit(int[] prices) {
    int result = 0;
    int min = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      }
      result = Math.max(result, prices[i] - min);
    }
    return result;
  }
  // end::answer[]
}
