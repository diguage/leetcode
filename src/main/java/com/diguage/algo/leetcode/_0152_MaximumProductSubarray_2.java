package com.diguage.algo.leetcode;

public class _0152_MaximumProductSubarray_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-02 11:10:11
   */
  public int maxProduct(int[] nums) {
    int[] maxDp = new int[nums.length];
    int[] minDp = new int[nums.length];
    maxDp[0] = nums[0];
    minDp[0] = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      minDp[i] = Math.min(Math.min(nums[i], minDp[i - 1] * nums[i]), maxDp[i - 1] * nums[i]);
      maxDp[i] = Math.max(Math.max(nums[i], maxDp[i - 1] * nums[i]), minDp[i - 1] * nums[i]);
      result = Math.max(result, maxDp[i]);
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0152_MaximumProductSubarray_2().maxProduct(new int[]{2, -5, -2, -4, 3});
  }
}
