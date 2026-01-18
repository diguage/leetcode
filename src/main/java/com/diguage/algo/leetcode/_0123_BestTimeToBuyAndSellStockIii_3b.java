package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0123_BestTimeToBuyAndSellStockIii_3b {
  // tag::answer[]

  /**
   * 暴力破解（201/214）-> 备忘录（14.46%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-18 22:10:31
   */
  public int maxProfit(int[] prices) {
    int[][][] memo = new int[2][3][prices.length];
    for (int[][] ms : memo) {
      for (int[] m : ms) {
        Arrays.fill(m, Integer.MIN_VALUE / 2);
      }
    }
    return dfs(prices, prices.length - 1, 0, 2, memo);
  }

  private int dfs(int[] prices, int index, int hold, int step, int[][][] memo) {
    // 任何情况下，step 都不能为负
    if (step < 0) {
      return Integer.MIN_VALUE / 2;
    }
    if (index < 0) {
      if (hold == 1) {
        // 第 0 天，不可能持有股票
        return Integer.MIN_VALUE / 2;
      } else {
        // 第 0 天，未持有股票，则利润为 0
        return 0;
      }
    }
    System.out.printf("hold=%d, step=%d, %d, index=%d\n", hold, step, step - 1, index);
    if (memo[hold][step][index] != Integer.MIN_VALUE / 2) {
      return memo[hold][step][index];
    }
    if (hold == 1) {
      return memo[hold][step][index] = Math.max(
        dfs(prices, index - 1, 1, step, memo),
        dfs(prices, index - 1, 0, step, memo) - prices[index]);
    }
    // 只在卖出时，更新交易次数。所以，在这里将 step - 1
    return memo[hold][step][index] = Math.max(
      dfs(prices, index - 1, 0, step, memo),
      dfs(prices, index - 1, 1, step - 1, memo) + prices[index]);
  }
  // end::answer[]

  static void main() {
    new _0123_BestTimeToBuyAndSellStockIii_3b()
//      .maxProfit(new int[]{2, 1, 2, 0, 1});
      .maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
  }
}
