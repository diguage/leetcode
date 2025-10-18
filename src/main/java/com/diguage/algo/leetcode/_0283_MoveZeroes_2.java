package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0283_MoveZeroes_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-18 22:33:09
   */
  public void moveZeroes(int[] nums) {
    int index = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[index++] = num;
      }
    }
    Arrays.fill(nums, index, nums.length, 0);
  }
  // end::answer[]
}
