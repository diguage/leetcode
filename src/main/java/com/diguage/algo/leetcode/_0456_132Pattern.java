package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0456_132Pattern {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-24 19:46:45
   */
  public boolean find132pattern(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int k = Integer.MIN_VALUE;
    for (int i = n - 1; i >= 0; i--) {
      // k 初始化时是 Integer.MIN_VALUE，
      // 当出现小于 k 的元素时，说明 k 被更新过了，
      //                     也说明栈中有元素且比 k 大
      if (nums[i] < k) {
        return true;
      }
      // 单调递减栈，遇到大的元素，就把小的都弹出来
      while (!stack.isEmpty() && stack.peekLast() < nums[i]) {
        // 在弹出来的小的元素里面，找最大的元素
        k = Math.max(k, stack.pollLast());
      }
      stack.addLast(nums[i]);
    }
    return false;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0456_132Pattern().find132pattern(new int[]{1, -4, 2, -1, 3, -3, -4, 0, -3, -1});
  }
}
