package com.diguage.algo.leetcode;

import jnr.ffi.annotations.In;

import java.util.*;

public class _0740_DeleteAndEarn_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-20 12:45:14
   */
  public int deleteAndEarn(int[] nums) {
    int max = Arrays.stream(nums).max().getAsInt();
    int[] values = new int[max + 1];
    for (int num : nums) {
      values[num] += num;
    }
    int[] dp = new int[max + 2];
    dp[1] = values[0];
    for (int i = 2; i <= max + 1; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + values[i - 1]);
    }
    return dp[max + 1];
  }
  // end::answer[]

  static void main() {
    new _0740_DeleteAndEarn_2().deleteAndEarn(new int[]{3, 4, 2});
  }
}
