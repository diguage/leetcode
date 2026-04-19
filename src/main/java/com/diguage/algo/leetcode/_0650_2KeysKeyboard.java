package com.diguage.algo.leetcode;

public class _0650_2KeysKeyboard {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-19 08:33:48
   */
  public int minSteps(int n) {
    int[] dp = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        if (i % j == 0) {
          dp[i] = Math.min(dp[i], dp[j] + i / j);
          dp[i] = Math.min(dp[i], dp[i / j] + j);
        }
      }
    }
    return dp[n];
  }
  // end::answer[]
}
