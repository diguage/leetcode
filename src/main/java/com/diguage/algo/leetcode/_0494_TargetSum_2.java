package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0494_TargetSum_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-08 17:39:59
   */
  public int findTargetSumWays(int[] nums, int target) {
    int sum = Arrays.stream(nums).sum();
    if (sum < Math.abs(target)) {
      return 0;
    }
    if ((sum + target) % 2 == 1) {
      return 0;
    }
    int positive = (sum + target) / 2;
    int negative = (sum - target) / 2;
    int capacity = Math.min(positive, negative);
    int[][] dp = new int[capacity + 1][nums.length + 1];
    dp[0][0] = 1;
    for (int i = 0; i <= capacity; i++) {
      for (int j = 1; j <= nums.length; j++) {
        if (i < nums[j - 1]) {
          dp[i][j] = dp[i][j - 1]; // 数字大于期望值，只能不选
        } else {
          dp[i][j] = dp[i][j - 1] + dp[i - nums[j - 1]][j - 1];
        }
      }
    }
    return dp[capacity][nums.length];
  }

  // end::answer[]
  static void main() {
    new _0494_TargetSum_2()
      .findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
  }
}
