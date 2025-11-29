package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0032_LongestValidParentheses_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-29 15:30:57
   */
  public int longestValidParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        if (stack.size() == 1) {
          stack.pop();
          stack.push(i);
        } else {
          stack.pop();
          result = Math.max(result, i - stack.peek());
        }
      }
    }
    return result;
  }
  // end::answer[]
}
