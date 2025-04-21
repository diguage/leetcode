package com.diguage.algo.leetcode;

public class _0189_RotateArray_2 {
  // tag::answer[]

  /**
   * AB → rev(B)rev(A) → rev(rev(B))rev(rev(A)) → BA
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-05 13:05
   */
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    k %= len;
    if (k == 0) {
      return;
    }
    reverse(nums, 0, len - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, len - 1);
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
}
