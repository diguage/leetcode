package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0239_SlidingWindowMaximum_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-01 08:09:17
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> stack = new ArrayDeque<>(k + 1);
    int[] result = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
        stack.pollLast();
      }
      stack.offerLast(i);
      if (stack.peekFirst() <= i - k) {
        stack.pollFirst();
      }
      if (i >= k - 1) {
        result[i - k + 1] = nums[stack.peekFirst()];
      }
    }
    return result;
  }
  // end::answer[]
}
