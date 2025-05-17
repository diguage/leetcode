package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0045_JumpGameIi_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-17 21:14:27
   */
  public int jump(int[] nums) {
    int length = nums.length;
    int[] dp = new int[length];
    Arrays.fill(dp, length + 1);
    dp[0] = 0;
    for (int i = 0; i < length; i++) {
      int min = Math.min(length - 1, i + nums[i]);
      for (int j = i + 1; j <= min; j++) {
        dp[j] = Math.min(dp[j], dp[i] + 1);
      }
    }
    return dp[length - 1];
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0045_JumpGameIi_2()
      .jump(new int[]{2, 3, 1, 1, 4});
  }
}
