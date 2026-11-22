package com.diguage.algo.leetcode;

public class _0031_NextPermutation_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-22 22:44:35
   */
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int less = nums.length - 2, more = nums.length - 1;
    while (less >= 0) {
      if (nums[less] < nums[more]) {
        break;
      }
      less--;
      more--;
    }
    int left = 0, right = nums.length - 1;
    if (less >= 0) {
      more = nums.length - 1;
      while (less < more) {
        if (nums[less] < nums[more]) {
          break;
        }
        more--;
      }
      swap(nums, less, more);
      left = less + 1;
    }
    reverse(nums, left, right);
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }

  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
  // end::answer[]
}
