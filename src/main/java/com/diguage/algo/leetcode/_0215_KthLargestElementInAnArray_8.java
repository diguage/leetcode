package com.diguage.algo.leetcode;

public class _0215_KthLargestElementInAnArray_8 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-02 22:34:30
   */
  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, nums.length - k, 0, nums.length - 1);
  }

  private int quickSelect(int[] nums, int k, int low, int high) {
    if (low == high) {
      return nums[k];
    }
    int pivot = nums[low];
    int l = low - 1, h = high + 1;
    while (l < h) {
      do {
        l++;
      } while (nums[l] < pivot);
      do {
        h--;
      } while (pivot < nums[h]);
      if (l >= h) {
        break;
      }
      int tmp = nums[l];
      nums[l] = nums[h];
      nums[h] = tmp;
    }
    if (k <= h) {
      return quickSelect(nums, k, low, h);
    } else {
      return quickSelect(nums, k, h + 1, high);
    }
  }
  // end::answer[]
}
