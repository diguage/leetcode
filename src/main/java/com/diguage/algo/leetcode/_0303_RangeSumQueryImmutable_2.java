package com.diguage.algo.leetcode;

public class _0303_RangeSumQueryImmutable_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-07 18:14:41
   */
  class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
      sums = new int[nums.length + 1];
      for (int i = 1; i < sums.length; i++) {
        sums[i] = sums[i - 1] + nums[i - 1];
      }
    }

    public int sumRange(int left, int right) {
      return sums[right + 1] - sums[left];
    }
  }
  // end::answer[]
}
