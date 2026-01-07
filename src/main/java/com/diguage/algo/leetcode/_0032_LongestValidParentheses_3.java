package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0032_LongestValidParentheses_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-07 20:02:19
   */
  public int longestValidParentheses(String s) {
    int result = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    char[] chars = s.toCharArray();
    boolean[] valid = new boolean[chars.length];
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (c == '(') {
        stack.push(i);
        continue;
      }
      if (stack.isEmpty()) {
        continue;
      }
      valid[i] = true;
      valid[stack.pop()] = true;
    }
    int cnt = 0;
    for (boolean v : valid) {
      if (v) {
        cnt++;
        result = Math.max(result, cnt);
      } else {
        cnt = 0;
      }
    }
    return result;
//    int start = -1, end = -1;
//    for (int i = 0; i < chars.length; i++) {
//      char c = chars[i];
//      if (c == '(') {
//        stack.push(i);
//        continue;
//      }
//      if (stack.isEmpty()) {
//        continue;
//      }
//      if (chars[stack.peek()] == '(') {
//        if (start == -1 || start == stack.peek() + 1) {
//          start = stack.peek();
//          end = i;
//          result = Math.max(result, end - start + 1);
//        } else if (stack.peek() == end + 1) {
//          end = i;
//          result = Math.max(result, end - start + 1);
//        } else {
//          start = -1;
//        }
//      }
//    }
//    return result;
  }

  // end::answer[]
  static void main() {
    new _0032_LongestValidParentheses_3()
//      .longestValidParentheses("(()");
//      .longestValidParentheses(")()())");
      .longestValidParentheses("()(())");
  }
}
