package com.diguage.algo.leetcode;

public class _0674_LongestContinuousIncreasingSubsequence {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-04 20:58:57
   */
  public int findLengthOfLCIS(int[] nums) {
    int result = 1;
    int curr = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] < nums[i]) {
        curr++;
        result = Math.max(result, curr);
      } else {
        curr = 1;
      }
    }
    return result;
  }
  // end::answer[]
}
