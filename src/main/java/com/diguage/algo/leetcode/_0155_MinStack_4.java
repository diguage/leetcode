package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0155_MinStack_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-31 22:38:19
   */
  class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
      stack = new ArrayDeque<>();
      min = new ArrayDeque<>();
    }

    public void push(int val) {
      stack.push(val);
      if (min.isEmpty() || val <= min.peek()) {
        min.push(val);
      } else {
        min.push(min.peek());
      }
    }

    public void pop() {
      stack.pop();
      min.pop();
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return min.peek();
    }
  }
  // end::answer[]
}
