package com.diguage.algo.leetcode;

public class _0027_RemoveElement_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-20 18:25:23
   */
  public static int removeElement(int[] nums, int val) {
    int slow = 0, fast = 0;
    while (fast < nums.length) {
      if (nums[fast] == val) {
        fast++;
      }else {
        nums[slow++] = nums[fast++];
      }
    }
    return slow;
  }
  // end::answer[]
}
