package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0322_CoinChange_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-09 11:36:55
   */
  public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    // 1、确定 dp 数组（dp table）以及下标的含义
    //   兑换 i 元钱，最少需要多少个货币
    int[] dp = new int[max];
    // 3、dp 数组如何初始化
    //   由于求最小值，则初始化比金额大一的数
    //   注：初始化为 Integer.MAX_VALUE 时，需要处理溢出问题
    Arrays.fill(dp, max);
    dp[0] = 0;
    // 4、确定遍历顺序，先金额从小到大开始遍历，再逐个货币进行尝试
    //   注：这样遍历，就可以尽可能多次使用大大额货币，比如
    //     f(11) = f(11-5) + 1 = (f(11-5-5) + 1) + 1 = 3
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        // 2、确定递推公式：f(n+1) = min{f(n+1), f(n) + 1}
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }
  return dp[amount] >= max ? -1 : dp[amount];
  // 原始解法，当做一个对比放在这里吧
  //    if (amount == 0) {
  //      return -1;
  //    }
  //    Arrays.sort(coins);
  //    int[] dp = new int[amount + 1];
  //    Arrays.fill(dp, Integer.MAX_VALUE);
  //    dp[0] = 0;
  //    for (int coin : coins) {
  //      for (int i = 1; i <= amount; i++) {
  //        for (int j = 1; j * coin <= i; j++) {
  //          int pre = dp[i - j * coin];
  //          if (pre < Integer.MAX_VALUE) {
  //            dp[i] = Math.min(dp[i], pre + j);
  //          }
  //        }
  //      }
  //    }
  //    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0322_CoinChange_3().coinChange(new int[]{2}, 3);
  }
}
