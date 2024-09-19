package com.diguage.algo.leetcode;

public class _0136_SingleNumber_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 14:48:40
   */
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }
  // end::answer[]
}
