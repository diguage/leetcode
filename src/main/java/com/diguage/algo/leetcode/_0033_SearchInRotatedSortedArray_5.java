package com.diguage.algo.leetcode;

public class _0033_SearchInRotatedSortedArray_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-28 22:52:27
   */
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    int head = nums[0];
    int tail = nums[nums.length - 1];
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int num = nums[mid];
      if (num == target) {
        return mid;
      }

      if (head <= num) {
        // 前面有序，先看在不在前面
        if (head <= target && target < num) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        // 后面有序，先看在不在后面
        if (num < target && target <= tail) {
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
    new _0033_SearchInRotatedSortedArray_5()
      .search(new int[]{3, 1},1);
  }
}
