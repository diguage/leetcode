package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0123_BestTimeToBuyAndSellStockIii_3c {
  // tag::answer[]

  /**
   * 暴力破解（201/214）-> 备忘录（14.46%）-> 动态规划
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-18 22:29:51
   */
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int k = 2;
    int[][][] dp = new int[n + 1][k + 2][2];
    for (int[][] ds : dp) {
      for (int[] d : ds) {
        Arrays.fill(d, Integer.MIN_VALUE / 2);
      }
    }
    for (int j = 1; j <= k + 1; j++) {
      dp[0][j][0] = 0;
    }
    for (int index = 1; index <= n; index++) {
      for (int step = 1; step <= 3; step++) {
        dp[index][step][0] = Math.max(dp[index - 1][step][0], dp[index - 1][step - 1][1] + prices[index - 1]);
        dp[index][step][1] = Math.max(dp[index - 1][step][1], dp[index - 1][step][0] - prices[index - 1]);
      }
    }
    return dp[n + 1][k + 1][0];
//    int n = prices.length;
//    int hold = 2;
//    int k = 2;
//    int[][][] dp = new int[hold][k + 1][n + 1];
//    for (int[][] ds : dp) {
//      for (int[] d : ds) {
//        Arrays.fill(d, Integer.MIN_VALUE / 2);
//      }
//    }
//    for (int j = 1; j <= k; j++) {
//      dp[0][j][0] = 0;
//    }
//
//    // dp[1][step][index] = max(dp[1][step][index-1], dp[0][step][index-1] - prices[index])
//    // dp[0][step][index] = max(dp[0][step][index-1], dp[1][step-1][index-1] + prices[index])
//    for (int index = 1; index <= n; index++) {
//      for (int step = 1; step <= 2; step++) {
//        dp[1][step][index] = Math.max(dp[1][step][index - 1], dp[0][step][index - 1] - prices[index - 1]);
//        dp[0][step][index] = Math.max(dp[0][step][index - 1], dp[1][step - 1][index - 1] + prices[index - 1]);
//      }
//    }
//    return dp[0][2][n];
  }
  // end::answer[]

  static void main() {
    new _0123_BestTimeToBuyAndSellStockIii_3c()
//      .maxProfit(new int[]{2, 1, 2, 0, 1});
      .maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
  }
}
