package com.diguage.algo.leetcode;

public class _0055_JumpGame_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-07 23:17:39
   */
  public boolean canJump(int[] nums) {
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > index) {
        return false;
      }
      index = Math.max(index, i + nums[i]);
      if (index >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }
  // end::answer[]
}

