package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * = 155. Min Stack
 *
 * https://leetcode.com/problems/min-stack/[Min Stack - LeetCode]
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * * push(x) -- Push element x onto stack.
 * * pop() -- Removes the element on top of the stack.
 * * top() -- Get the top element.
 * * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * .Example:
 * [source]
 * ----
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-24 16:40
 */
class _0155_MinStack_2 {
  // tag::answer[]
  private Deque<Integer> stack = new LinkedList<>();
  private Deque<Integer> minStack = new LinkedList<>();
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-31 16:09:25
   */
  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty()) {
      minStack.push(x);
    } else {
      if (x < minStack.peek()) {
        minStack.push(x);
      } else {
        minStack.push(minStack.peek());
      }
    }
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
  // end::answer[]
}


