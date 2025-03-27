package com.diguage.algo.leetcode;

public class _0041_FirstMissingPositive_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-27 22:16:54
   */
  public int firstMissingPositive(int[] nums) {
    int length = nums.length;
    for (int i = 0; i < length; ) {
      int num = nums[i];
      if (0 < num && num < length && num != nums[num - 1]) {
        // 元素在数组长度范围内，并且不在数字对应的下标（num-1）的位置就交换
        int temp = nums[num - 1];
        nums[num - 1] = num;
        // 要交换 i 与 num -1
        nums[i] = temp;
      } else {
        // 只有在当前位置无法处理（超出数组访问）
        // 或无需处理（数字与下标对应）时，才向前推进
        i++;
      }
    }
    // 从前向后遍历，第一个数字和下标不对应的数字就是答案
    for (int i = 0; i < length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return length + 1;
  }
  // end::answer[]
}
