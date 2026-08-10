package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0856_ScoreOfParentheses {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-10 22:08:50
   */
  public int scoreOfParentheses(String s) {
    Deque<String> stack = new ArrayDeque<>();
    for (char p : s.toCharArray()) {
      if (p == '(') {
        stack.push(String.valueOf(p));
      } else {
        if ("(".equals(stack.peek())) {
          stack.pop();
          stack.push("1");
        } else {
          int temp = 0;
          while (!"(".equals(stack.peek())) {
            temp += Integer.parseInt(stack.pop());
          }
          stack.poll();
          stack.push(String.valueOf(2 * temp));
        }
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += Integer.parseInt(stack.pop());
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0856_ScoreOfParentheses()
      .scoreOfParentheses("(()(()))");
  }
}
