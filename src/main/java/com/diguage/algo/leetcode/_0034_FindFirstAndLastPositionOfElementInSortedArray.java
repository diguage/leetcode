package com.diguage.algo.leetcode;

/**
 * == 34. Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/[Find First and Last Position of Element in Sorted Array - LeetCode]
 *
 * Given an array of integers `nums` sorted in ascending order, find the
 * starting and ending position of a given `target` value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return `[-1, -1]`.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-09-16 20:50 初次完成，2024-07-01 17:24:23 优化
 */
public class _0034_FindFirstAndLastPositionOfElementInSortedArray {
  // tag::answer[]
  public static int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    // 搜索左边界
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        right = mid - 1; // 注意这里的处理
      }
    }
    if (left == nums.length) {
      return new int[]{-1, -1};
    }
    int i1 = -1;
    if (nums[left] == target) {
      i1 = left;
    } else {
      return new int[]{-1, -1};
    }
    // 搜索右边界
    left = 0;
    right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        left = mid + 1; // 注意这里的处理
      }
    }
    if (left - 1 < 0) {
      return new int[]{-1, -1};
    }
    int i2 = -1;
    if (nums[left - 1] == target) {
      i2 = left - 1;
    } else {
      return new int[]{-1, -1};
    }
    return new int[]{i1, i2};
  }
  // end::answer[]
}
