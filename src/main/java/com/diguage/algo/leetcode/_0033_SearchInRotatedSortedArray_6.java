package com.diguage.algo.leetcode;

public class _0033_SearchInRotatedSortedArray_6 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-09 21:10:51
   */
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int num = nums[mid];
      if (num == target) {
        return mid;
      }
      if (nums[left] <= num) {
        if (nums[left] <= target && target < num) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (num < target && target <= nums[nums.length - 1]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  // end::answer[]
  static void main() {
    new _0033_SearchInRotatedSortedArray_6()
      .search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
  }
}
