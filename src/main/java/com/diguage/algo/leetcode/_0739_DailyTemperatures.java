package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _0739_DailyTemperatures {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-05 23:35:54
   */
  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null || temperatures.length == 0) {
      return temperatures;
    }
    int[] result = new int[temperatures.length];
    Deque<Integer> stack = new LinkedList<>();
    for (int i = temperatures.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        result[i] = stack.peek() - i;
      }
      stack.push(i);
    }
    return result;
  }
  // end::answer[]
}
