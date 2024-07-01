package com.diguage.algorithm.leetcode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-01 15:22:49
 */
public class _0704_BinarySearch {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
