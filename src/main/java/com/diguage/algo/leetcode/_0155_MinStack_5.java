package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0155_MinStack_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-08 22:38:59
   */
  class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    public MinStack() {
      stack = new ArrayDeque<>();
      min = new ArrayDeque<>();
    }

    public void push(int value) {
      stack.push(value);
      if (min.isEmpty()) {
        min.push(value);
      } else {
        if (min.peekFirst() < value) {
          min.push(min.peekFirst());
        } else {
          min.push(value);
        }
      }
    }

    public void pop() {
      stack.pop();
      min.pop();
    }

    public int top() {
      return stack.peekFirst();
    }

    public int getMin() {
      return min.peekFirst();
    }
  }
  // end::answer[]
}
