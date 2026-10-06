package com.diguage.algo.leetcode;

public class _0189_RotateArray_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-06 21:46:57
   */
  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    if (k == 0) {
      return;
    }
    revert(nums, 0, nums.length - k - 1);
    revert(nums, nums.length - k, nums.length - 1);
    revert(nums, 0, nums.length - 1);
  }

  private void revert(int[] nums, int low, int high) {
    while (low < high) {
      int temp = nums[low];
      nums[low] = nums[high];
      nums[high] = temp;
      low++;
      high--;
    }
  }
  // end::answer[]
}
