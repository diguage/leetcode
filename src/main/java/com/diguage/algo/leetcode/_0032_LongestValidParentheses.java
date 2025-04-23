package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0032_LongestValidParentheses {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-23 16:49:57
   */
  public int longestValidParentheses(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    boolean[] holder = new boolean[s.length()];
    List<Integer> stack = new ArrayList<>(s.length());
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.add(i);
      } else if (c == ')') {
        if (!stack.isEmpty()) {
          holder[i] = true;
          holder[stack.removeLast()] = true;
        }
      }
    }
    int result = 0;
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (holder[i]) {
        cnt++;
        result = Math.max(result, cnt);
      } else {
        cnt = 0;
      }
    }
    return result;
  }
  // end::answer[]
}
