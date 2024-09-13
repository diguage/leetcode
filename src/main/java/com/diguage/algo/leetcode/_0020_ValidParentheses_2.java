package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _0020_ValidParentheses_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 16:51:17
   */
  public boolean isValid(String s) {
    Deque<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.addLast(c);
      } else if (c == ')') {
        if (stack.isEmpty() || stack.peekLast() != '(') {
          return false;
        } else {
          stack.removeLast();
        }
      } else if (c == ']') {
        if (stack.isEmpty() || stack.peekLast() != '[') {
          return false;
        } else {
          stack.removeLast();
        }
      } else if (c == '}') {
        if (stack.isEmpty() || stack.peekLast() != '{') {
          return false;
        } else {
          stack.removeLast();
        }
      }
    }
    return stack.isEmpty();
  }
  // end::answer[]
}
