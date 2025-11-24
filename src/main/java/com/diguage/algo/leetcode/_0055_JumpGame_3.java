package com.diguage.algo.leetcode;

public class _0055_JumpGame_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-24 22:20
   */
  public boolean canJump(int[] nums) {
    int farthest = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > farthest) {
        return false;
      }
      farthest = Math.max(farthest, i + nums[i]);
      if (farthest >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }
  // end::answer[]
}
