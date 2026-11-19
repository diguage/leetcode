package com.diguage.algo.leetcode;

public class _0033_SearchInRotatedSortedArray_7 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-19 23:11:20
   */
  public int search(int[] nums, int target) {
    int n = nums.length;
    int left = 0, right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] < nums[n - 1]) {
        // 优先检查是否在有序的序列中
        if (nums[mid] < target && target <= nums[n - 1]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        // 优先检查是否在有序的序列中
        if (nums[0] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }
  // end::answer[]
}
