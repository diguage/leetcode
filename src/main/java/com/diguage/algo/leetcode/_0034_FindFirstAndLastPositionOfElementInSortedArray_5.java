package com.diguage.algo.leetcode;

public class _0034_FindFirstAndLastPositionOfElementInSortedArray_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2018-09-16 21:32
   */
  public int[] searchRange(int[] nums, int target) {
    if (null == nums || nums.length == 0) {
      return new int[]{-1, -1};
    }
    int index = search(nums, target);
    if (index < 0 || nums.length <= index || nums[index] != target) {
      return new int[]{-1, -1};
    }
    return new int[]{index, search(nums, target + 1) - 1};
  }

  private int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
  // end::answer[]
}
