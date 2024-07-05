package com.diguage.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _0503_NextGreaterElementII {
  /**
   * 参考 496 题，自己写出来的
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-05 23:08:39
   */
  public int[] nextGreaterElements(int[] nums) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    int[] result = new int[nums.length];
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 2 * nums.length - 1; i >= 0; i--) {
      int index = i % nums.length;
      while (!stack.isEmpty() && stack.peek() <= nums[index]) {
        stack.pop();
      }
      result[index] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums[index]);
    }
    return result;
  }
}
