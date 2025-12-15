package com.diguage.algo.leetcode;

public class _0053_MaximumSubarray_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-15 20:47:26
   */
  public int maxSubArray(int[] nums) {
    int result = nums[0];
    int curr = 0;
    for (int num : nums) {
      curr = Math.max(curr + num, num);
      result = Math.max(result, curr);
    }
    return result;
  }
  // end::answer[]
}
