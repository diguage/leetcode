package com.diguage.algo.leetcode;

public class _0300_LongestIncreasingSubsequence_4b {
  // tag::answer[]
  /**
   * 暴力破解（23/56）-> 备忘录（5.03%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-20 21:01
   */
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int result = 0;
    int[] memo = new int[n];
    for (int i = 0; i < n; i++) {
      result = Math.max(result, dfs(nums, i, memo));
    }
    return result;
  }

  private int dfs(int[] nums, int index, int[] memo) {
    if (memo[index] > 0) {
      return memo[index];
    }
    int result = 0;
    for (int i = 0; i < index; i++) {
      if (nums[i] < nums[index]) {
        result = Math.max(result, dfs(nums, i, memo));
      }
    }
    return memo[index] = result + 1;
  }
  // end::answer[]
}
