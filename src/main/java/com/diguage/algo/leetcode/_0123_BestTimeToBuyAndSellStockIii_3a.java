package com.diguage.algo.leetcode;

public class _0123_BestTimeToBuyAndSellStockIii_3a {
  // tag::answer[]
  /**
   * 暴力破解（201/214）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-18 10:45:43
   */
  public int maxProfit(int[] prices) {
    return dfs(prices, prices.length - 1, 0, 2);
  }

  private int dfs(int[] prices, int index, int hold, int step) {
    if (step < 0) {
      return Integer.MIN_VALUE / 2;
    }
    if (index < 0) {
      if (hold == 1) {
        return Integer.MIN_VALUE / 2;
      } else {
        return 0;
      }
    }
    if (hold == 1) {
      return Math.max(dfs(prices, index - 1, 1, step),
        dfs(prices, index - 1, 0, step) - prices[index]);
    }
    // 只在卖出时，更新交易次数。所以，在这里将 step - 1
    return Math.max(dfs(prices, index - 1, 0, step),
      dfs(prices, index - 1, 1, step - 1) + prices[index]);
  }
  // end::answer[]

  static void main() {
    new _0123_BestTimeToBuyAndSellStockIii_3a()
      .maxProfit(new int[]{2, 1, 2, 0, 1});
//      .maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
  }
}
