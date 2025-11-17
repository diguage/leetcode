package com.diguage.algo.leetcode;

public class _0075_SortColors_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-17 21:37:31
   */
  public void sortColors(int[] nums) {
    int[] counter = new int[3];
    for (int num : nums) {
      counter[num]++;
    }
    int index = 0;
    for (int i = 0; i < counter.length; i++) {
      for (int j = 0; j < counter[i]; j++) {
        nums[index++] = i;
      }
    }
  }
  // end::answer[]
}
