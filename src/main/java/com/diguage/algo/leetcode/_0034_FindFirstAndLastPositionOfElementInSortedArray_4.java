package com.diguage.algo.leetcode;

public class _0034_FindFirstAndLastPositionOfElementInSortedArray_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-27 22:43:47
   */
  public int[] searchRange(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      // 循环不变量：
      // nums[left-1] < target
      // nums[right+1] >= target
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    if (right < 0 || left == nums.length || nums[left] != target) {
      return new int[]{-1, -1};
    }
    int a = left;

    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      // 循环不变量：
      // nums[left-1] >= target
      // nums[right+1] < target
      if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return new int[]{a, right};
  }
  // end::answer[]
}
