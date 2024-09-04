package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0416_PartitionEqualSubsetSum_2 {
  // tag::answer[]
  /**
   * 动态规划，没有优化空间
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-03 19:13:39
   */
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    // 特判：如果是奇数，就不符合要求
    if (sum % 2 != 0) {
      return false;
    }
    int length = nums.length;
    int target = sum / 2;
    // 创建二维状态数组，行：物品索引，列：容量（包括 0）
    // dp[i][j] 表示从数组的 [0, i] 这个子区间内挑选一些正整数，
    //          每个数只能用一次，使得这些数的和恰好等于 j。
    boolean[][] dp = new boolean[length][target + 1];

    // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
    if (nums[0] < target) {
      dp[0][nums[0]] = true;
    }

    for (int i = 1; i < length; i++) {
      for (int j = 0; j <= target; j++) {
        // 注：这里的 j 就相当于背包的容量
        // 直接从上一行先把结果抄下来，然后再修正
        dp[i][j] = dp[i - 1][j];
        if (nums[i] == j) {
          dp[i][j] = true;
        } else if (nums[i] < j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
        }
      }
    }
    return dp[length - 1][target];
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0416_PartitionEqualSubsetSum_2()
      .canPartition(new int[]{14, 9, 8, 4, 3, 2});
  }
}
