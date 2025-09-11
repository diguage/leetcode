package com.diguage.algo.leetcode;

public class _0402_RemoveKDigits_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-11 21:45:14
   */
  public String removeKdigits(String num, int k) {
    StringBuilder stack = new StringBuilder();
    char[] chars = num.toCharArray();
    stack.append(chars[0]);
    for (int i = 1; i < chars.length; i++) {
      char c = chars[i];
      while (k > 0 && !stack.isEmpty()
        && stack.charAt(stack.length() - 1) > c) {
        stack.deleteCharAt(stack.length() - 1);
        k--;
      }
      if (c == '0' && stack.isEmpty()) {
        continue;
      }
      stack.append(c);
    }
    for (int i = 0; i < k && !stack.isEmpty(); i++) {
      stack.deleteCharAt(stack.length() - 1);
    }
    return stack.isEmpty() ? "0" : stack.toString();
  }
  // end::answer[]
}
