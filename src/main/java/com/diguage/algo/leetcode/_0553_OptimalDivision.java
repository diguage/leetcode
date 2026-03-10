package com.diguage.algo.leetcode;

public class _0553_OptimalDivision {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-10 21:22:23
   */
  public String optimalDivision(int[] nums) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      result.append(nums[i]);
      if (i < nums.length - 1) {
        result.append("/");
      }
    }
    if (nums.length > 2) {
      result.insert(result.indexOf("/") + 1, "(");
      result.append(")");
    }
    return result.toString();
  }
  // end::answer[]
}
