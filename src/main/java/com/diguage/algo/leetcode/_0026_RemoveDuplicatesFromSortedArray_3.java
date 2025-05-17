package com.diguage.algo.leetcode;

public class _0026_RemoveDuplicatesFromSortedArray_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-17 20:48:52
   */
  public int removeDuplicates(int[] nums) {
    int slow = 0, fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != nums[slow]) {
        nums[++slow] = nums[fast];
      }
      fast++;
    }
    return slow + 1;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0026_RemoveDuplicatesFromSortedArray_3()
      .removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
  }

}
