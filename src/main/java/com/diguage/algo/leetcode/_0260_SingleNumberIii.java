package com.diguage.algo.leetcode;

public class _0260_SingleNumberIii {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-01 23:43:28
   */
  public int[] singleNumber(int[] nums) {
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }
    int mask = xor == Integer.MIN_VALUE ? xor : xor & (-xor);
    int num1 = 0, num2 = 0;
    for (int num : nums) {
      if (((num & mask)) == 0) {
        num1 ^= num;
      } else {
        num2 ^= num;
      }
    }
    return new int[]{num1, num2};
  }
  // end::answer[]
}
