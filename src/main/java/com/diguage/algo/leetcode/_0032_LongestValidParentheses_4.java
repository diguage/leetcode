package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0032_LongestValidParentheses_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-20 22:29:38
   */
  public int longestValidParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    char[] chars = s.toCharArray();
    boolean[] valid = new boolean[s.length()];
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '(') {
        stack.push(i);
      } else {
        if (stack.isEmpty()) {
          continue;
        }
        valid[stack.pop()] = true;
        valid[i] = true;
      }
    }
    int result = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (valid[i]) {
        max++;
        result = Math.max(result, max);
      } else {
        max = 0;
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0032_LongestValidParentheses_4().longestValidParentheses(")()())");
  }
}
