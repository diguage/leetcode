package com.diguage.algo.leetcode;

public class _0121_BestTimeToBuyAndSellStock_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-09 21:40:12
   */
  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int result = 0;
    for (int price : prices) {
      if (price < min) {
        min = price;
        max = price;
        continue;
      }
      max = Math.max(max, price);
      result = Math.max(result, max - min);
    }
    return result;
  }
  // end::answer[]
}
