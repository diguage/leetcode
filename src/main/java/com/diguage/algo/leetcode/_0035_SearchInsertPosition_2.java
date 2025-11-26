package com.diguage.algo.leetcode;

public class _0035_SearchInsertPosition_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-26 21:03:14
   */
  public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      // 循环不变量：
      // nums[left-1] < target
      // nums[right+1] >= target
      int mid = left + (right - left) / 2;
      int num = nums[mid];
     if (num < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right + 1; // 这里使用 left 也可以
  }
  // end::answer[]
  static void main() {
    new _0035_SearchInsertPosition_2()
      .searchInsert(new int[]{1, 3, 5, 6}, 2);
  }
}
