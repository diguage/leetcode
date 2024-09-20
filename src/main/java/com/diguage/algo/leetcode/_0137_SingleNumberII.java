package com.diguage.algo.leetcode;

public class _0137_SingleNumberII {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 14:48:40
   */
  public int singleNumber(int[] nums) {
    int[] bits = new int[32];
    for (int i = 0; i < 32; i++) {
      int cnt = 0;
      for (int j = 0; j < nums.length; j++) {
        int num = nums[j];
        cnt += (num & 1);
        nums[j] = (num >>> 1);
      }
      bits[i] = cnt % 3;
    }
    int result = 0;
    for (int i = 31; i >= 0; i--) {
      result <<= 1;
      result |= bits[i];
    }
    return result;
  }
  // end::answer[]
}
