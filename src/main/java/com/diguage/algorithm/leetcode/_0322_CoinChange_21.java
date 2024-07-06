package com.diguage.algorithm.leetcode;

import static com.diguage.util.Printers.printMatrix;

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
public class _0322_CoinChange_21 {
  // tag::answer[]

  /**
   * 参考 左程云《程序员代码面试指南》。完全没看明白。
   */
  public int coinChange(int[] coins, int amt) {
    if (coins == null || coins.length == 0 || amt < 0) {
      return -1;
    }
    int N = coins.length;
    int[][] dp = new int[N + 1][amt + 1];
    // 设置最后一排的值，除了 dp[N][0] 外，其他都是-1
    for (int i = 1; i <= amt; i++) {
      dp[N][i] = -1;
    }
    for (int i = N - 1; i >= 0; i--) {  // 从底向上计算每一行
      printMatrix(dp);
      for (int rest = 0; rest <= amt; rest++) { // 每一行都从左向右
        dp[i][rest] = -1; // 初始时，先设置 dp[i][rest] 的值无效。这样省去了一次遍历设置每一行的操作
        if (dp[i + 1][rest] != -1) { // 下面的值如果有效
          dp[i][rest] = dp[i + 1][rest]; // 先设置成下面的值
        }
        // 如果坐标的位置不越界且有效
        if (rest - coins[i] >= 0 && dp[i][rest - coins[i]] != -1) {
          if (dp[i][rest] == -1) { // 如果之前下面的值无效
            dp[i][rest] = dp[i][rest - coins[i]] + 1;
          } else { // 说明下面和左边的值都有效，取最小的
            dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - coins[i]] + 1);
          }
        }
      }
    }
    System.out.println("最后结果");
    printMatrix(dp);
    return dp[0][amt];
  }
  // end::answer[]
}
