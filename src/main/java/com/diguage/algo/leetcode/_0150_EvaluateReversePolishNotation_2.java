package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0150_EvaluateReversePolishNotation_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-08 22:16:19
   */
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
      switch (token) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          Integer b = stack.pop();
          Integer a = stack.pop();
          stack.push(a - b);
          break;
        case "*":
          stack.push(stack.pop() * stack.pop());
          break;
        case "/":
          Integer n = stack.pop();
          Integer m = stack.pop();
          stack.push(m / n);
          break;
        default:
          stack.push(Integer.parseInt(token));
      }
    }
    return stack.peek();
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0150_EvaluateReversePolishNotation_2()
      .evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
  }
}
