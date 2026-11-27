package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class _0020_ValidParentheses_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-27 22:52:47
   */
  public boolean isValid(String s) {
    Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (map.containsKey(c)) {
        Character pair = map.get(c);
        if (stack.isEmpty() || stack.peek() != pair) {
          return false;
        }
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
  // end::answer[]
}
