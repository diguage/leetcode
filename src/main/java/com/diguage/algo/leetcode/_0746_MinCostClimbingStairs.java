package com.diguage.algo.leetcode;

public class _0746_MinCostClimbingStairs {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-11 20:23:46
   */
  public int minCostClimbingStairs(int[] cost) {
    // dp[i] 表示到底第 i 阶时，所需最少费用
    int[] dp = new int[cost.length + 1];
    // 0 和 1 可以直接站上，所以不需要付费
    dp[0] = 0;
    dp[1] = 0;
    for (int i = 2; i < dp.length; i++) {
      // 第 i 阶，有两种走法
      // 1. 从第 i-1 阶走一步上去，花费： dp[i-1] 走到 i-1 的费用 + cost[i-1]（向上的费用）
      // 2. 从第 i-2 阶走两步上去，花肥： dp[i-2] 走到 i-2 的费用 + cost[i-2]（向上的费用）
      dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
    }
    return dp[dp.length - 1];
  }
  // end::answer[]
}
