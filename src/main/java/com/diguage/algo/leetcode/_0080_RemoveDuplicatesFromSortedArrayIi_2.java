package com.diguage.algo.leetcode;

public class _0080_RemoveDuplicatesFromSortedArrayIi_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-18 15:08:39
   */
  public int removeDuplicates(int[] nums) {
    int slow = 0, fast = 0, cnt = 1;
    while (fast < nums.length) {
      if (nums[fast] != nums[slow]) {
        cnt = 1;
        nums[++slow] = nums[fast];
      } else {
        if (cnt < 2 && slow != fast) {
          nums[++slow] = nums[fast];
          cnt++;
        }
      }
      fast++;
    }
    return slow + 1;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0080_RemoveDuplicatesFromSortedArrayIi_2()
      .removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
  }
}
