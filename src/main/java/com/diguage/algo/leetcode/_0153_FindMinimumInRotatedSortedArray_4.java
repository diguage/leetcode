package com.diguage.algo.leetcode;

public class _0153_FindMinimumInRotatedSortedArray_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-01 21:57:23
   */
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      // 只需要关注 nums[mid] 与最后一个数的大小关系即可
      // 如果 nums[mid] 更小，那么更小的数只能在前面，无论是否旋转。
      // 如果最后一个数更新，那么数组必定被旋转了，并且更小的数在后面。
      if (nums[mid] < nums[nums.length - 1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return nums[left];
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0153_FindMinimumInRotatedSortedArray_4()
      .findMin(new int[]{11, 13, 15, 17});
  }
}
