package com.diguage.algo.leetcode;

public class _0033_SearchInRotatedSortedArray_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-05 14:11:58
   */
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[0] <= nums[mid]) {
        // 由于 nums[0] <= nums[mid]，所以，这个分支处理的是前面有序的情况
        // --------------------------------------------
        // 上面已经判断过 nums[mid] 和 target 是否相等，
        // 这里就不需要再处理相等情况，所以，可以直接去 mid 左右的索引
        // 该分支前面有序，只需要在有序数组里去查找即可，不满足要求，则在另外一部分里。
        if (nums[0] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        // 上面只处理前面有序的情况，那么这里就可能是后面有序的情况。
        // --------------------------------------------
        // 上面已经判断过 nums[mid] 和 target 是否相等，
        // 这里就不需要再处理相等情况，所以，可以直接去 mid 左右的索引
        // 同理，这里也只在有序的数组里去查找，不满足要求则去另外一部分查找。
        if (nums[mid] < target && target <= nums[nums.length - 1]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
  // end::answer[]
}
