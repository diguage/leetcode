package com.diguage.algo.leetcode;


public class _0287_FindTheDuplicateNumber_4 {

  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-23 23:26:42
   */
  public int findDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i + 1) {
        int num = nums[i];
        if (nums[num - 1] == num) {
          return num;
        }
        nums[i] = nums[num - 1];
        nums[num - 1] = num;
      }
    }
    return 0;
  }
  // end::answer[]

}
