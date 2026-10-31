package com.diguage.algo.leetcode;

public class _0075_SortColors_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-31 22:16:51
   */
  public void sortColors(int[] nums) {
    int[] counter = new int[3];
    for (int num : nums) {
      counter[num]++;
    }
    int index = 0;
    for (int i = 0; i < 3; i++) {
      int cnt = counter[i];
      for (int j = 0; j < cnt; j++) {
        nums[index++] = i;
      }
    }
  }
  // end::answer[]
}
