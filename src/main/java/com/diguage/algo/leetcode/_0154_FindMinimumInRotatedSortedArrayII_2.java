package com.diguage.algo.leetcode;

public class _0154_FindMinimumInRotatedSortedArrayII_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 20:35:15
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
        right -= 1;
      }
    }
    return nums[left];
  }
  // end::answer[]
}
