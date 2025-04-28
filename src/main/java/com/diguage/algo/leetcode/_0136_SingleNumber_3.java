package com.diguage.algo.leetcode;

public class _0136_SingleNumber_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-28 08:51:28
   */
  public int singleNumber(int[] nums) {
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result ^= nums[i];
    }
    return result;
  }
  // end::answer[]
}
