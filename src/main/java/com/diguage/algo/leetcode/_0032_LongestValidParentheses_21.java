package com.diguage.algo.leetcode;

public class _0032_LongestValidParentheses_21 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-29 17:31:43
   */
  public int longestValidParentheses(String s) {
    int result = 0, left = 0, right = 0;
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c == '(') {
        left++;
      } else {
        right++;
      }
      // 从左向右时，右括号太多，则从零开始
      if (left < right) {
        left = right = 0;
      } else if (left == right) {
        result = Math.max(result, right * 2);
      }
    }
    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = chars[i];
      if (c == '(') {
        left++;
      } else {
        right++;
      }
      // 从左向右时，则左括号太多，就从零开始
      if (right < left) {
        left = right = 0;
      } else if (left == right) {
        result = Math.max(result, right * 2);
      }
    }
    return result;
  }
  // end::answer[]
}
