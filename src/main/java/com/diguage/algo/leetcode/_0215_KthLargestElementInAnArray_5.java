package com.diguage.algo.leetcode;

public class _0215_KthLargestElementInAnArray_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-02 15:49:20
   */
  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, nums.length - k, 0, nums.length - 1);
  }

  private int quickSelect(int[] nums, int k, int left, int right) {
    if (left >= right) {
      return nums[k];
    }
    int pivot = nums[left];
    int l = left - 1, r = right + 1;
    while (l < r) {
      do {
        l++;
      } while (nums[l] < pivot);
      do {
        r--;
      } while (pivot < nums[r]);
      if (l < r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
      }
    }
    if (k <= r) {
      return quickSelect(nums, k, left, r);
    } else {
      return quickSelect(nums, k, r + 1, right);
    }
  }
  // end::answer[]
}
