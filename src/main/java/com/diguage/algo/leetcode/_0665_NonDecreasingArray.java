package com.diguage.algo.leetcode;

public class _0665_NonDecreasingArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-28 21:33:56
   */
  public boolean checkPossibility(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int x = nums[i], y = nums[i + 1];
      if (x > y) {
        count++;
        if (count > 1) {
          return false;
        }
        if (i > 0 && y < nums[i - 1]) {
          nums[i + 1] = x;
        }
      }
    }
    return true;
  }
  // end::answer[]
}
