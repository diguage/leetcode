package com.diguage.algo.leetcode;

public class _0121_BestTimeToBuyAndSellStock_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 07:44:20
   */
  public int maxProfit(int[] prices) {
    int result = 0;
    int min = 100000;
    for (int p : prices) {
      min = Math.min(min, p);
      result = Math.max(result, p - min);
    }
    return result;
  }
  // end::answer[]
}
