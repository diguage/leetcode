package com.diguage.algo.leetcode;

public class _0377_CombinationSumIv {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-26 22:19:09
   */
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i >= nums[j]) {
          dp[i] += dp[i - nums[j]];
        }
      }
    }
    return dp[target];
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0377_CombinationSumIv().combinationSum4(new int[]{1, 2, 3}, 4);
  }
}
