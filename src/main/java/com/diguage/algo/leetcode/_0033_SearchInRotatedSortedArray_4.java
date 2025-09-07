package com.diguage.algo.leetcode;

public class _0033_SearchInRotatedSortedArray_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-07 21:09:02
   */
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[0] <= nums[mid]) { // 前段有序
        // 现在目标值是否在有序部分
        if (nums[0] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else { // 后端有序
        // 现在目标值是否在有序部分
        if (nums[mid] <= target && target <= nums[nums.length - 1]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
  // end::answer[]

//  先找拐点，再找目标值。代码还需要完善
//  public int search(int[] nums, int target) {
//    if (nums.length == 1 && nums[0] == target) {
//      return 0;
//    }
//    int idx = findMinIndex(nums);
//    if (nums[0] <= target) {
//      return binarySearch(nums, target, 0, idx - 1);
//    } else {
//      return binarySearch(nums, target, idx, nums.length - 1);
//    }
//  }
//
//  private static int findMinIndex(int[] nums) {
//    int left = 0, right = nums.length - 1;
//    while (left < right) {
//      int mid = left + (right - left) / 2;
//      if (nums[0] < nums[mid]) {
//        left = mid + 1;
//      } else {
//        right = mid;
//        if (nums[right - 1] > nums[right]) {
//          break;
//        }
//      }
//    }
//    return right;
//  }
//
//  private int binarySearch(int[] nums, int target, int start, int end) {
//    while (start <= end) {
//      int mid = start + (end - start) / 2;
//      if (nums[mid] == target) {
//        return mid;
//      } else if (nums[mid] < target) {
//        start = mid + 1;
//      } else if (target < nums[mid]) {
//        end = mid - 1;
//      }
//    }
//    return -1;
//  }


  public static void main(String[] args) {
    new _0033_SearchInRotatedSortedArray_4()
      .search(new int[]{1, 3}, 0);
  }
}
