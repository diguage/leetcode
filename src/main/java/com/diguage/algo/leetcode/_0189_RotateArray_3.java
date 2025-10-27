package com.diguage.algo.leetcode;

public class _0189_RotateArray_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-27 21:59:50
   */
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - k - 1);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0189_RotateArray_3()
      .rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
  }
}
