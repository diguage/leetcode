package com.diguage.algo.leetcode;

public class _0300_LongestIncreasingSubsequence_4a {
  // tag::answer[]
  /**
   * 暴力破解（23/56）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-20 20:46:59
   */
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int result = 0;
    for (int i = 0; i < n; i++) {
      result = Math.max(result, dfs(nums, i));
    }
    return result;
  }

  private int dfs(int[] nums, int index) {
    int result = 0;
    for (int i = 0; i < index; i++) {
      if (nums[i] < nums[index]) {
        result = Math.max(result, dfs(nums, i));
      }
    }
    return result + 1;
  }
  // end::answer[]
}
