package com.diguage.algo.leetcode;

public class _0416_PartitionEqualSubsetSum_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-05 22:10:32
   */
  public boolean canPartition(int[] nums) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    int target = sum / 2;
    if (sum % 2 != 0 || max > target) {
      return false;
    }
    int length = nums.length;
    boolean[][] dp = new boolean[length + 1][target + 1];
    dp[0][0] = true;
    for (int i = 0; i < length; i++) {
      int num = nums[i];
      for (int j = 0; j <= target; j++) {
        dp[i + 1][j] = dp[i][j] || j >= num && dp[i][j - num];
      }
      // 如果可以提前找到满足条件的情况，则直接返回
      if (dp[i + 1][target]) {
        return true;
      }
    }

    return dp[length][target];
  }
  // end::answer[]

  static void main() {
    new _0416_PartitionEqualSubsetSum_3()
      .canPartition(new int[]{1, 5, 11, 5});
  }
}
