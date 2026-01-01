package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0746_MinCostClimbingStairs_3b {
  // tag::answer[]
  /**
   * 暴力破解（259/285） → 备忘录（77.11%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-01 16:07:11
   */
  public int minCostClimbingStairs(int[] cost) {
    int[] memo = new int[cost.length + 1];
    Arrays.fill(memo, -1);
    return dfs(cost, cost.length, memo);
  }

  private int dfs(int[] cost, int index, int[] memo) {
    if (index < 2) {
      return 0;
    }
    if (memo[index] >= 0) {
      return memo[index];
    }
    return memo[index] = Math.min(
      dfs(cost, index - 1, memo) + cost[index - 1],
      dfs(cost, index - 2, memo) + cost[index - 2]);
  }
  // end::answer[]
}
