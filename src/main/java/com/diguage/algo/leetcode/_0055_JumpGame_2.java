package com.diguage.algo.leetcode;

public class _0055_JumpGame_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-19 14:50:01
   */
  public boolean canJump(int[] nums) {
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, i + nums[i]);
      if (max >= nums.length - 1) {
        return true;
      }
      if (max < i) {
        return false;
      }
    }
    return false;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0055_JumpGame_2()
      .canJump(new int[]{3, 2, 1, 0, 4});
  }
}
