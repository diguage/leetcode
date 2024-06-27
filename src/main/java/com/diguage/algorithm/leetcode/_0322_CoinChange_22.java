package com.diguage.algorithm.leetcode;

import java.util.Arrays;

/**
 * = 322. Coin Change
 *
 * https://leetcode.com/problems/coin-change/[Coin Change - LeetCode]
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.
 *
 * .Example 2:
 * [source]
 * ----
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: coins = [2], amount = 3
 * Output: -1
 * ----
 *
 * *Note:*
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-26 22:16
 */
public class _0322_CoinChange_22 {

  /**
   * 参考 https://leetcode.cn/problems/coin-change/solutions/132979/322-ling-qian-dui-huan-by-leetcode-solution/[322. 零钱兑换 - 官方题解^]
   */
  public int coinChange(int[] coins, int amt) {
    if (coins == null || coins.length == 0 || amt < 0) {
      return -1;
    }
    int max = amt + 1;
    int[] dp = new int[max];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amt; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }
    return dp[amt] > amt ? -1 : dp[amt];
  }
}
