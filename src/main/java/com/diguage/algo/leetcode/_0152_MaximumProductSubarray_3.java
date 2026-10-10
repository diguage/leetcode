package com.diguage.algo.leetcode;

public class _0152_MaximumProductSubarray_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-10 22:28:11
   */
  public int maxProduct(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      int a = num * min;
      int b = num * max;
      min = Math.min(num, Math.min(a, b));
      max = Math.max(num, Math.max(a, b));
      result = Math.max(result, max);
    }
    return result;
  }
  // end::answer[]
}
