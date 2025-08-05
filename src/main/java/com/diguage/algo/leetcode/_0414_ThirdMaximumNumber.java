package com.diguage.algo.leetcode;

public class _0414_ThirdMaximumNumber {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-05 22:41:27
   */
  public int thirdMax(int[] nums) {
    long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
    for (int num : nums) {
      if (num > a) {
        c = b;
        b = a;
        a = num;
      } else if (num < a && num > b) {
        c = b;
        b = num;
      } else if (num < b & num > c) {
        c = num;
      }
    }
    return c > Long.MIN_VALUE ? (int) c : (int) a;
  }
  // end::answer[]
}
