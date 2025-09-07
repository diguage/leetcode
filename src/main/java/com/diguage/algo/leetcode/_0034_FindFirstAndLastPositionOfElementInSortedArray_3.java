package com.diguage.algo.leetcode;

public class _0034_FindFirstAndLastPositionOfElementInSortedArray_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-07 20:23:06
   */
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    int left = binarySearch(nums, target, true);
    if (left == -1) {
      return new int[]{-1, -1};
    }
    int right = binarySearch(nums, target, false);
    return new int[]{left, right};
  }

  private int binarySearch(int[] nums, int target, boolean isLeftSide) {
    int left = 0, right = nums.length - 1;
    int result = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target < nums[mid]) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        if (isLeftSide) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
        result = mid;
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0034_FindFirstAndLastPositionOfElementInSortedArray_3()
      .searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
  }
}
