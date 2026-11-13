package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0045_JumpGameIi_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-13 23:23:00
   */
  public int jump(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, n);
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      for (int j = i + 1; j <= i + num && j < n; j++) {
        dp[j] = Math.min(dp[j], dp[i] + 1);
      }
    }
    return dp[n - 1];
  }

  // end::answer[]
  static void main() {
    new _0045_JumpGameIi_3().jump(new int[]{2, 3, 1, 1, 4});
  }
}
