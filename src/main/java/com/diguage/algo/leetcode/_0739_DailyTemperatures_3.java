package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0739_DailyTemperatures_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-10 23:21:01
   */
  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>();
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
