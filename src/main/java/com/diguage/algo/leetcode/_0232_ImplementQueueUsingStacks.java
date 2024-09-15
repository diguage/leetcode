package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _0232_ImplementQueueUsingStacks {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 21:11:15
   */
  class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;


    public MyQueue() {
      inStack = new LinkedList<>();
      outStack = new LinkedList<>();
    }

    public void push(int x) {
      inStack.push(x);
    }

    public int pop() {
      int peek = peek();
      outStack.pop();
      return peek;
    }

    public int peek() {
      if (!outStack.isEmpty()) {
        return outStack.peek();
      } else {
        while (!inStack.isEmpty()) {
          outStack.push(inStack.pop());
        }
      }
      // TODO 这里， outStack 有可能是空啊？！
      return outStack.peek();
    }

    public boolean empty() {
      return inStack.isEmpty() && outStack.isEmpty();
    }
  }
  // end::answer[]
}
