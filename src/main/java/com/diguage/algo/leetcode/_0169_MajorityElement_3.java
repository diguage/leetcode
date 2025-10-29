package com.diguage.algo.leetcode;

public class _0169_MajorityElement_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-29 22:22:09
   */
  public int majorityElement(int[] nums) {
    int num = 0;
    int result = 0;
    for (int i : nums) {
      if (num == 0) {
        num = 1;
        result = i;
      } else {
        num += i == result ? +1 : -1;
      }
    }
    return result;
  }
  // end::answer[]
}
