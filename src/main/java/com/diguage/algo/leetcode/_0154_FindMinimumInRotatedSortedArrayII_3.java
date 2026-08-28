package com.diguage.algo.leetcode;

public class _0154_FindMinimumInRotatedSortedArrayII_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-28 23:17:06
   */
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < nums[right]) {
        right = mid;
      } else if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right--;
      }
    }
    return nums[left];
  }
  // end::answer[]
}
