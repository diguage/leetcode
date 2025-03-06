package com.diguage.algo.leetcode;

public class _0081_SearchInRotatedSortedArrayIi_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-06 14:46:31
   */
  public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      // 相等则直接返回
      if (nums[mid] == target) {
        return true;
      }
      if (nums[left] == nums[mid]) {
        // 移动左指针，即可避开重复元素
        left++;
        continue;
      }
      if (nums[left] <= nums[mid]) {
        //前面有序，且目标值在该区间内，则在有序部分内查找
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          // 反之，则在无序区间内查找
          left = mid + 1;
        }
      } else {
        //后面有序，且目标值在该区间内，则在有序部分内查找
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          // 反之，则在无序区间内查找
          right = mid - 1;
        }
      }
    }
    return false;
  }
  // end::answer[]
}
