package com.diguage.algorithm.leetcode;

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
public class _0322_CoinChange_2 {

  /**
   * 最笨的方法：暴力穷举，超时
   */
  public int coinChange(int[] coins, int amount) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    int result = Integer.MAX_VALUE;
    for (int coin : coins) {
      int cnt = coinChange(coins, amount - coin);
      if (cnt == -1) {
        continue;
      }
      result = Math.min(result, cnt + 1);
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public static void main(String[] args) {
    _0322_CoinChange_2 solution = new _0322_CoinChange_2();
    int result = solution.coinChange(new int[]{1, 2, 5}, 11);
    System.out.println("result = " + result + " : " + (result == 3));
  }
}
