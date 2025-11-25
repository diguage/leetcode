package com.diguage.algo.leetcode;

public class _0041_FirstMissingPositive_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-25 22:02:15
   */
  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i + 1) {
        int num = nums[i];
        if (num < 1 || num > nums.length) {
          nums[i] = -1;
          break;
        }
        int temp = nums[num - 1];
        if (temp == num) {
          break;
        }
        nums[num - 1] = num;
        nums[i] = temp;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  // end::answer[]
  static void main() {
    new _0041_FirstMissingPositive_5()
      .firstMissingPositive(new int[]{2, 1});
  }
}
