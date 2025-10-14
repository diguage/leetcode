package com.diguage.algo.leetcode;

public class _0416_PartitionEqualSubsetSum_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-14 15:16:47
   */
  public boolean canPartition(int[] nums) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    int target = sum / 2;
    if (sum % 2 == 1 || max > target) {
      return false;
    }
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int num : nums) {
      for (int i = target; i >= num; i--) {
        dp[i] |= dp[i - num];
      }
    }
    return dp[target];
  }

  // end::answer[]
  static void main() {
    new _0416_PartitionEqualSubsetSum_5()
      .canPartition(new int[]{1, 5, 11, 5});
  }
}
