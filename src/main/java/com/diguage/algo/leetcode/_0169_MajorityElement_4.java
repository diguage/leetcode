package com.diguage.algo.leetcode;

public class _0169_MajorityElement_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-07 22:11:20
   */
  public int majorityElement(int[] nums) {
    int cnt = 0;
    int result = 0;
    for (int num : nums) {
      if (cnt == 0) {
        result = num;
        cnt = 1;
      } else {
        cnt += num == result ? 1 : -1;
      }
    }
    return result;
  }
  // end::answer[]
}
