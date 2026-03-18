package com.diguage.algo.leetcode;

public class _0565_ArrayNesting {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-18 21:40:58
   */
  public int arrayNesting(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == -1) {
        continue;
      }
      int index = i;
      int count = 0;
      while (nums[index] != -1) {
        count++;
        int tmp = nums[index];
        nums[index] = -1;
        index = tmp;
      }
      result = Math.max(result, count);
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0565_ArrayNesting()
      .arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2});
  }
}
