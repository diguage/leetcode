package com.diguage.algo.leetcode;

public class _0215_KthLargestElementInAnArray_7 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-12 20:47:38
   */
  public int findKthLargest(int[] nums, int k) {
    return quickselect(nums, nums.length - k, 0, nums.length - 1);
  }

  private int quickselect(int[] nums, int k, int low, int high) {
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
      } while (nums[h] > pivot);
      if (l < h) {
        int tmp = nums[l];
        nums[l] = nums[h];
        nums[h] = tmp;
      }
    }
    if (k <= h) {
      return quickselect(nums, k, low, h);
    } else {
      return quickselect(nums, k, h + 1, high);
    }
  }
  // end::answer[]

  static void main() {
    new _0215_KthLargestElementInAnArray_7()
      .findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
  }
}
