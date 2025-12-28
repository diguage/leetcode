package com.diguage.algo.leetcode;

public class _0189_RotateArray_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-28 20:23:28
   */
  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    if (k == 0) {
      return;
    }
    k = nums.length - k;
    reverse(nums, k, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }
  // end::answer[]
}
