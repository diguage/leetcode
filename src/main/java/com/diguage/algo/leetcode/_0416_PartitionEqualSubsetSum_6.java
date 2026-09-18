package com.diguage.algo.leetcode;

public class _0416_PartitionEqualSubsetSum_6 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-18 23:28:48
   */
  public boolean canPartition(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return false;
    }
    int sum = 0;
    int max = 0;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    int target = sum / 2;
    if ((sum & 1) == 1 || max > target) {
      return false;
    }
    boolean[][] dp = new boolean[target + 1][n + 1];
    dp[0][0] = true;
    for (int i = 0; i <= target; i++) {
      for (int j = 0; j < n; j++) {
        int num = nums[j];
        dp[i][j + 1] = dp[i][j] || i >= num && dp[i - num][j];
      }
    }
    return dp[target][n];
  }
  // end::answer[]
}
