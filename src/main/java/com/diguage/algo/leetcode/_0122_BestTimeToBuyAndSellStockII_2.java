package com.diguage.algo.leetcode;

public class _0122_BestTimeToBuyAndSellStockII_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-14 14:48:19
   */
  public int maxProfit(int[] prices) {
    int result = 0;
    for (int i = 1; i < prices.length - 1; i++) {
      // 只要发现价差就进行交易
      if (prices[i - 1] < prices[i]) {
        result += (prices[i] - prices[i - 1]);
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0122_BestTimeToBuyAndSellStockII_2()
      .maxProfit(new int[]{1, 2, 3, 4, 5});
  }
}
