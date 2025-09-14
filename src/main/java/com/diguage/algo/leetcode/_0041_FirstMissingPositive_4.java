package com.diguage.algo.leetcode;

public class _0041_FirstMissingPositive_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-14 22:15:15
   */
  public int firstMissingPositive(int[] nums) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      while (nums[i] > 0 && nums[i] < length && nums[i] != i + 1) {
        int num = nums[i];
        if (nums[num - 1] == num) {
          break;
        }
        nums[i] = nums[num - 1];
        nums[num - 1] = num;
      }
    }
    for (int i = 0; i < length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return length + 1;
  }
  // end::answer[]
}
