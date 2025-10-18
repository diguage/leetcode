package com.diguage.algo.leetcode;

public class _0283_MoveZeroes_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-18 22:33:09
   */
  public void moveZeroes(int[] nums) {
    int slow = 0, fast = 0;
    while (fast < nums.length) {
      if (nums[fast] == 0 || fast == slow) {
        fast++;
        continue;
      }
      if (nums[slow] != 0) {
        slow++;
        continue;
      }
      nums[slow] = nums[fast];
      nums[fast] = 0;
      slow++;
      fast++;
    }
  }
  // end::answer[]
}
