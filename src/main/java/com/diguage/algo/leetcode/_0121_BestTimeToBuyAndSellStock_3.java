package com.diguage.algo.leetcode;

public class _0121_BestTimeToBuyAndSellStock_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-10 20:48:34
   */
  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int result = Integer.MIN_VALUE;
    for (int price : prices) {
      min = Math.min(min, price);
      result = Math.max(result, price - min);
    }
    return result;
  }
  // end::answer[]
}
