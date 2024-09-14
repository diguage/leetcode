package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _0155_MinStack_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-31 16:09:25
   */
  class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
      stack = new LinkedList<>();
      min = new LinkedList<>();
    }

    public void push(int val) {
      stack.push(val);
      if (min.isEmpty() || val < min.peek()) {
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
