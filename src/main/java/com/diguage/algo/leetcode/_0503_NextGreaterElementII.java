package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _0503_NextGreaterElementII {
  // tag::answer[]
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
    // 只需要将数组“拼接”，遍历两遍数组，就可以解决所有元素后继更大元素的问题
    // 从后向前遍历，再加上单调递增栈，就是时间复杂度为 O(n) 的解决方案
    for (int i = 2 * nums.length - 1; i >= 0; i--) {
      // 取余即可获取当前需要处理的元素
      int index = i % nums.length;
      // 在单调栈不为空的情况下，将栈中小于等于当前元素的值都弹出
      while (!stack.isEmpty() && stack.peek() <= nums[index]) {
        stack.pop();
      }
      // 剩下元素既是比当前元素大的后继元素。为空则是没有更大元素
      // 这里还有一个隐含变量：
      // 由于栈是从后向前添加，则栈顶元素距离当前元素更近。
      // 如果栈不为空，则栈顶元素就是符合条件的元素。
      result[index] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums[index]);
    }
    return result;
  }
  // end::answer[]
}
