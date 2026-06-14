package com.diguage.algo.leetcode;

public class _0775_GlobalAndLocalInversions {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-14 22:08:22
   */
  public boolean isIdealPermutation(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (Math.abs(nums[i] - i) > 1) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
  static void main() {
    new _0775_GlobalAndLocalInversions().isIdealPermutation(new int[]{2, 0, 1});
  }
}
