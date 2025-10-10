package com.diguage.algo.leetcode;

public class _0518_CoinChangeIi_1 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-10 16:56:01
   */
  public int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    dp[0][0] = 1;
    for (int i = 0; i < coins.length; i++) {
      for (int j = 0; j <= amount; j++) {
        if (coins[i] > j) {
          dp[i + 1][j] = dp[i][j];
        } else {
          dp[i + 1][j] = dp[i][j] + dp[i + 1][j - coins[i]];
        }
      }
    }
    return dp[coins.length][amount];
  }

  // end::answer[]
  static void main() {
    new _0518_CoinChangeIi_1().change(5, new int[]{1, 2, 5});
  }
}
