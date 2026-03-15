package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0561_ArrayPartition {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-15 20:31:16
   */
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    for (int i = 0; i < nums.length; i += 2) {
      result += nums[i];
    }
    return result;
  }
  // end::answer[]
}
