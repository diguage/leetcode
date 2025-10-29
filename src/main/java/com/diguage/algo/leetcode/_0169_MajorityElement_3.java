package com.diguage.algo.leetcode;

public class _0169_MajorityElement_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-29 22:22:09
   */
  public int majorityElement(int[] nums) {
    int num = 0;
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (num == 0) {
        index = i;
      }
      if (nums[i] == nums[index]) {
        num++;
      } else {
        num--;
      }
    }
    return nums[index];
  }
  // end::answer[]
}
