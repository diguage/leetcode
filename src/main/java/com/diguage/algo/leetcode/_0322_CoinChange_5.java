package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0322_CoinChange_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-09 19:57:15
   */
  public int coinChange(int[] coins, int amount) {
    int MAX = amount + 1;
    // dp[j] 表示凑成金额 j 所需的最少硬币数
    int[] dp = new int[MAX];
    // 初始化 dp 数组为一个最大值，方便后面取 min
    Arrays.fill(dp, MAX);
    dp[0] = 0; // 凑成金额0需要0个硬币
    for (int coin : coins) {
      // 完全背包：正序遍历容量
      for (int j = coin; j <= amount; j++) {
        // 决策：不使用这枚coin vs 使用这枚coin
        dp[j] = Math.min(dp[j], dp[j - coin] + 1);
      }
    }
    return dp[amount] == MAX ? -1 : dp[amount];
  }
  // end::answer[]
  static void main() {
    new _0322_CoinChange_5().coinChange(new int[]{1, 2, 5}, 11);

  }
}
