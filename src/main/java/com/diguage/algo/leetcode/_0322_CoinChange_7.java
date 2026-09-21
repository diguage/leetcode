package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0322_CoinChange_7 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-21 23:10:15
   */
  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    Arrays.sort(coins);
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Integer.min(dp[i], dp[i - coin] + 1);
        }
      }
    }
    return dp[amount] == max ? -1 : dp[amount];
  }
  // end::answer[]
}
