package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0122_BestTimeToBuyAndSellStockIi_4b {
  // tag::answer[]

  /**
   * 暴力破解（198/202）-> 备忘录（5.16%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-17 16:13:38
   */
  public int maxProfit(int[] prices) {
    int[][] memo = new int[2][prices.length];
    for (int[] ints : memo) {
      Arrays.fill(ints, Integer.MIN_VALUE);
    }
    return dfs(prices, prices.length - 1, 0, memo);
  }

  private int dfs(int[] prices, int index, int hold, int[][] memo) {
    if (index < 0) {
      if (hold == 1) {
        return Integer.MIN_VALUE;
      } else {
        return 0;
      }
    }
    if (memo[hold][index] != Integer.MIN_VALUE) {
      return memo[hold][index];
    }
    if (hold == 1) {
      return memo[hold][index] = Math.max(dfs(prices, index - 1, 1, memo),
        dfs(prices, index - 1, 0, memo) - prices[index]);
    }
    return memo[hold][index] = Math.max(dfs(prices, index - 1, 0, memo),
      dfs(prices, index - 1, 1, memo) + prices[index]);
  }
  // end::answer[]
}
