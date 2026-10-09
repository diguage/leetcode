package com.diguage.algo.leetcode;

public class _0153_FindMinimumInRotatedSortedArray_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-09 20:07:25
   */
  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] < nums[nums.length - 1]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return nums[low];
  }
  // end::answer[]
}

