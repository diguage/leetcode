package com.diguage.algo.leetcode;

public class _0031_NextPermutation_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-27 21:43:16
   */
  public void nextPermutation(int[] nums) {
    int index = nums.length - 2;
    while (index >= 0) {
      if (nums[index] < nums[index + 1]) {
        break;
      }
      index--;
    }
    if (index < 0) {
      reverse(nums, 0, nums.length - 1);
      return;
    }
    int big = nums.length - 1;
    while (index < big) {
      if (nums[index] < nums[big]) {
        break;
      }
      big--;
    }
    swap(nums, index, big);
    reverse(nums, index + 1, nums.length - 1);
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }
  // end::answer[]
}
