package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0239_SlidingWindowMaximum_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-26 22:30:21
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < k - 1; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        stack.pop();
      }
      stack.push(i);
    }
    int n = nums.length;
    int[] result = new int[n - k + 1];
    for (int i = k - 1; i < n; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        stack.pop();
      }
      stack.push(i);
      result[i - (k - 1)] = nums[stack.getLast()];
      if (stack.getLast() <= i - (k - 1)) {
        stack.removeLast();
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0239_SlidingWindowMaximum_5()
      .maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
//      .maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
