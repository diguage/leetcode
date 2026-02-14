package com.diguage.algo.leetcode;

public class _0376_WiggleSubsequence_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-14 23:17:36
   */
  public int wiggleMaxLength(int[] nums) {
    int down = 1, up = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] < nums[i]) {
        up = down + 1;
      } else if (nums[i - 1] > nums[i]) {
        down = up + 1;
      }
    }
    return nums.length == 0 ? 0 : Math.max(down, up);
  }
  // end::answer[]
}
