package com.diguage.algo.leetcode;


public class _0268_MissingNumber_2 {
  // tag::answer[]

  /**
   * 循环排序的解法
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-29 19:07:11
   */
  public int missingNumber(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] != i && nums[i] < n) {
        swap(nums, nums[i], i--);
      }
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return n;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0268_MissingNumber_2().missingNumber(new int[]{1});
  }
}
