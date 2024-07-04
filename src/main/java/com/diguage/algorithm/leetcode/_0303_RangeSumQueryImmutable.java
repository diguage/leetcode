package com.diguage.algorithm.leetcode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-04 16:46:40
 */
public class _0303_RangeSumQueryImmutable {
  class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
      sums = new int[nums.length + 1];
      int sum = 0;
      sums[0] = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        sums[i + 1] = sum;
      }
    }

    public int sumRange(int left, int right) {
      return sums[right + 1] - sums[left];
    }
  }
}
