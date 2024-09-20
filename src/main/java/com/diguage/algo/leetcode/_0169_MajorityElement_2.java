package com.diguage.algo.leetcode;

public class _0169_MajorityElement_2 {
  // tag::answer[]
  /**
   * 摩尔投票法
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-20 21:38:37
   */
  public int majorityElement(int[] nums) {
    int votes = 0, x = nums[0];
    for (int num : nums) {
      if (votes == 0) {
        x = num;
      }
      if (num == x) {
        votes++;
      } else {
        votes--;
      }
    }
    return x;
  }
  // end::answer[]
}
