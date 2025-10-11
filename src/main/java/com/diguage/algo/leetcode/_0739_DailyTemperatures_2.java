package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0739_DailyTemperatures_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-11 22:26:38
   */
  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = temperatures.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
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
  static void main() {
    new _0739_DailyTemperatures_2()
//      .dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
      .dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70});
  }
}
