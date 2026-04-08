package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0628_MaximumProductOfThreeNumbers {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-08 19:20:07
   */
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    // 最大的三个数字
    int result = nums[n - 1] * nums[n - 2] * nums[n - 3];
    // 最大的数字和最小的两个数字
    result = Math.max(result, nums[0] * nums[1] * nums[n - 1]);
    return result;
  }

  // end::answer[]
  static void main() {
    new _0628_MaximumProductOfThreeNumbers().maximumProduct(new int[]{});
  }
}
