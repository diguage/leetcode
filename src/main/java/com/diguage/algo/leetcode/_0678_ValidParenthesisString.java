package com.diguage.algo.leetcode;

public class _0678_ValidParenthesisString {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-08 21:35:40
   */
  public boolean checkValidString(String s) {
    int min = 0, max = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        min++;
        max++;
      } else if (c == ')') {
        min = Math.max(min - 1, 0);
        max--;
        if (max < 0) {
          return false;
        }
      } else {
        min = Math.max(min - 1, 0);
        max++;
      }
    }
    return min == 0;
  }
  // end::answer[]
}
