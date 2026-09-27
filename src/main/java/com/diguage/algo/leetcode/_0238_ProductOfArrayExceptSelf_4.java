package com.diguage.algo.leetcode;

public class _0238_ProductOfArrayExceptSelf_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-27 22:28:15
   */
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    result[0] = 1;
    for (int i = 1; i < n; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }
    int product = 1;
    for (int i = n - 1; i >= 0; i--) {
      result[i] *= product;
      product *= nums[i];
    }
    return result;
  }
  // end::answer[]
}
