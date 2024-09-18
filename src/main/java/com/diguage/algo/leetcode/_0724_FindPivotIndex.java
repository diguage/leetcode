package com.diguage.algo.leetcode;

public class _0724_FindPivotIndex {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 21:45:49
   */
  public int pivotIndex(int[] nums) {
    int length = nums.length;
    int[] dp = new int[length + 2];
    for (int i = length; i > 0; i--) {
      dp[i] = nums[i - 1] + dp[i + 1];
    }
    for (int i = 1; i <= length; i++) {
      if (dp[i - 1] == dp[i + 1]) {
        return i - 1;
      }
      dp[i] = nums[i - 1] + dp[i - 1];
    }
    return -1;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0724_FindPivotIndex()
      .pivotIndex(new int[]{-1, -1, 0, 0, -1, -1});
  }
}
