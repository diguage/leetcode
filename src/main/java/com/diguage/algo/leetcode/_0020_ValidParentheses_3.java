package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class _0020_ValidParentheses_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-04 21:33:30
   */
  public boolean isValid(String s) {
    if ((s.length() & 1) == 1) {
      return false;
    }
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Character> parentheses = Map.of(')', '(', '}', '{', ']', '[');
    for (char c : s.toCharArray()) {
      if (!parentheses.containsKey(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty() || stack.pop() != parentheses.get(c)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
  // end::answer[]
}
