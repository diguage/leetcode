package com.diguage.algo.leetcode;

public class _0416_PartitionEqualSubsetSum_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-09 19:15:56
   */
  public boolean canPartition(int[] nums) {
    int sum = 0, max = Integer.MIN_VALUE;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    int target = sum / 2;
    if (sum % 2 == 1 || max > target) {
      return false;
    }
    // dp[j] 为一个布尔值，表示容量为 j 的背包是否能被恰好装满。
    // dp[j] = 是否存在 nums 的一个子集，其和恰好为 j
    boolean[] dp = new boolean[target + 1];
    dp[0] = true; // 容量为0的背包总能被“空集”装满
    for (int num : nums) {
      // 因为每个数字（物品）只能用一次，是典型的 0/1 背包，所以内层循环必须逆序遍历，
      // 以保证 dp[j - num] 的值是上一轮循环留下的，而不是被当前的 num 更新过的。
      for (int i = target; i >= num; i--) {
        // dp[j] 要想为 true，要么它原来就为 true（不放 num），
        //                   要么 dp[j - num] 为 true（放入 num）
        dp[i] = dp[i] || dp[i - num];
      }
    }
    return dp[target];
  }
  // end::answer[]

  static void main() {
    new _0416_PartitionEqualSubsetSum_4().canPartition(new int[]{1, 5, 11, 5});
  }
}
