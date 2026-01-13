package com.diguage.algo.leetcode;

public class _0137_SingleNumberIi_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-13 09:00:24
   */
  public int singleNumber(int[] nums) {
    int[] sums = new int[32];
    for (int num : nums) {
      for (int i = 0; num != 0 && i < 32; i++) {
        sums[i] += (num >>> i) & 1;
      }
    }
    int result = 0;
    for (int i = 31; i >= 0; i--) {
      result <<= 1;
      if (sums[i] % 3 == 1) {
        result |= 1;
      }
    }
    return result;
  }
  // end::answer[]
}
