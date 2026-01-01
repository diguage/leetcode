package com.diguage.algo.leetcode;

public class _0746_MinCostClimbingStairs_3c {
  // tag::answer[]
  /**
   * 暴力破解（259/285） → 备忘录（77.11%）→ 动态规划（77.11%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-01 16:10:40
   */
  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    for (int i = 2; i <= cost.length; i++) {
      // dp[i] = min(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1])
      dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i-1]);
    }
    return dp[cost.length];
  }
  // end::answer[]
}
