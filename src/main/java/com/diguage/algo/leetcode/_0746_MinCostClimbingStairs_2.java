package com.diguage.algo.leetcode;

public class _0746_MinCostClimbingStairs_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-16 19:56:08
   */
  public int minCostClimbingStairs(int[] cost) {
    int a = 0, b = 0, result = 0;
    for (int i = 2; i <= cost.length; i++) {
      // 第 i 阶，有两种走法
      // 1. 从第 i-1 阶走一步上去，花费： dp[i-1] 走到 i-1 的费用 + cost[i-1]（向上的费用）
      // 2. 从第 i-2 阶走两步上去，花肥： dp[i-2] 走到 i-2 的费用 + cost[i-2]（向上的费用）
      result = Math.min(a + cost[i - 2], b + cost[i - 1]);
      a = b;
      b = result;
    }
    return result;
  }
  // end::answer[]
}
