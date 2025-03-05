package com.diguage.algo.leetcode;


public class _0034_FindFirstAndLastPositionOfElementInSortedArray_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-04 21:02:59
   */
  public int[] searchRange(int[] nums, int target) {
    int left = binarySearch(nums, target, true);
    if (left == -1) {
      return new int[]{-1, -1};
    }
    int right = binarySearch(nums, target, false);
    return new int[]{left, right};
  }

  private int binarySearch(int[] nums, int target, boolean isLeft) {
    int left = 0;
    int right = nums.length - 1;
    // 使用 result 变量，省去很多繁琐的判断
    int result = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        if (isLeft) {
          // 注意：找左边界，要收缩右指针
          right = mid - 1;
        } else {
          // 注意：找右边界，要搜索左指针
          left = mid + 1;
        }
        result = mid;
      }
    }
    return result;
  }

  // 下面是原始代码，上面是优化后的代码
  private int binarySearchLeft(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    // 使用 result 变量，省去很多繁琐的判断
    int result = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        // 注意：找左边界，要收缩右指针
        right = mid - 1;
        result = mid;
      }
    }
    return result;
  }

  private int binarySearchRight(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    // 使用 result 变量，省去很多繁琐的判断
    int result = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        // 注意：找右边界，要搜索左指针
        left = mid + 1;
        result = mid;
      }
    }
    return result;
  }
  // end::answer[]
}
