package com.diguage.algo.leetcode;

public class _0153_FindMinimumInRotatedSortedArray_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-09 22:03:22
   */
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[0] < nums[mid] && nums[mid] < nums[nums.length - 1]) {
        right = mid;
      } else if (nums[0] < nums[mid]) {
        left = mid + 1;
      } else if (nums[mid] < nums[nums.length - 1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return nums[right];
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0153_FindMinimumInRotatedSortedArray_3()
      .findMin(new int[]{2, 1});
  }
}
