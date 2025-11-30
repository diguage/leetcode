package com.diguage.algo.leetcode;


public class _0031_NextPermutation_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-30 18:46:38
   */
  public void nextPermutation(int[] nums) {
    int index = nums.length - 2;
    while (index >= 0) {
      if (nums[index] < nums[index + 1]) {
        break;
      }
      index--;
    }
    if (index == -1) {
      reverse(nums, 0, nums.length - 1);
      return;
    }
    int big = nums.length - 1;
    while (big > index) {
      if (nums[big] > nums[index]) {
        break;
      }
      big--;
    }
    swap(nums, index, big);
    reverse(nums, index + 1, nums.length - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  private static void swap(int[] nums, int index, int big) {
    int temp = nums[index];
    nums[index] = nums[big];
    nums[big] = temp;
  }
  // end::answer[]
}
