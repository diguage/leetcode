package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0322_CoinChange_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-06 20:30:27
   */
  public int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin > i) {
          break;
        }
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  // end::answer[]
  static void main() {
    new _0322_CoinChange_4()
      .coinChange(new int[]{1, 2, 5}, 11);
  }
}
