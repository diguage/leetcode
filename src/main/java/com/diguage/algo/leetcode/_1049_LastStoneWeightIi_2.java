package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1049_LastStoneWeightIi_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-10 22:26:53
   */
  public int lastStoneWeightII(int[] stones) {
    int sum = Arrays.stream(stones).sum();
    int target = sum / 2;
    int[] dp = new int[target + 1];
    for (int stone : stones) {
      for (int i = target; i >= stone; i--) {
        dp[i] = Math.max(dp[i], dp[i - stone] + stone);
      }
    }
    return sum - 2 * dp[target];
  }
  // end::answer[]
  static void main() {
    new _1049_LastStoneWeightIi_2()
      .lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
  }
}
