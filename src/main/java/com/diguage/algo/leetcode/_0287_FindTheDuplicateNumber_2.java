package com.diguage.algo.leetcode;

public class _0287_FindTheDuplicateNumber_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 22:05:18
   */
  public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;
    do {
      slow = nums[slow];
      fast = nums[fast];
      fast = nums[fast];
    } while(slow != fast);
    slow = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }
  // end::answer[]
}
