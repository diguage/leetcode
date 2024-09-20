package com.diguage.algo.leetcode;

public class _0215_KthLargestElementInAnArray_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-20 23:27:08
   */
  public int findKthLargest(int[] nums, int k) {
    // 第 k 大，即为第 n - k 小
    return quickselect(nums, nums.length - k, 0, nums.length - 1);
  }

  private int quickselect(int[] nums, int k, int left, int right) {
    if (left == right) {
      return nums[k];
    }
    int pivot = nums[left], l = left - 1, r = right + 1;
    while (l < r) {
      do {
        l++;
      } while (nums[l] < pivot);
      do {
        r--;
      } while (nums[r] > pivot);
      if (l < r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
      }
    }
    if (k <= r) {
      return quickselect(nums, k, left, r);
    } else {
      return quickselect(nums, k, r + 1, right);
    }
  }
  // end::answer[]
}
