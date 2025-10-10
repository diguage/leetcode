package com.diguage.algo.leetcode;

public class _0518_CoinChangeIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-10 09:41:28
   */
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i - coin];
      }
    }
    return dp[amount];
  }

  // end::answer[]
  static void main() {
    new _0518_CoinChangeIi().change(5, new int[]{1, 2, 5});
  }
}
