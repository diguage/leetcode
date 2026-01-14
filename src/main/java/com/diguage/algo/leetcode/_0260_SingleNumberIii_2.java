package com.diguage.algo.leetcode;

public class _0260_SingleNumberIii_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-14 09:19:37
   */
  public int[] singleNumber(int[] nums) {
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }
    int mask = 1;
    for (int i = 0; i < 32; i++) {
      mask = 1 << i;
      if ((xor & mask) == mask) {
        break;
      }
    }
    int a = 0, b = 0;
    for (int num : nums) {
      if ((num & mask) == 0) {
        a ^= num;
      } else {
        b ^= num;
      }
    }
    return new int[]{a, b};
  }
  // end::answer[]
}
