package com.diguage.algo.leetcode;

public class _0746_MinCostClimbingStairs_3a {
  // tag::answer[]
  /**
   * 暴力破解（259/285）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-01 15:35:51
   */
  public int minCostClimbingStairs(int[] cost) {
    return dfs(cost, cost.length);
  }

  private int dfs(int[] cost, int index) {
    if (index < 2) {
      return 0;
    }
    return Math.min(dfs(cost, index - 1) + cost[index - 1],
      dfs(cost, index - 2) + cost[index - 2]);
  }
  // end::answer[]
}
