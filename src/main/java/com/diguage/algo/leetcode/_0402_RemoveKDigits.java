package com.diguage.algo.leetcode;

public class _0402_RemoveKDigits {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-16 19:48:26
   */
  public String removeKdigits(String num, int k) {
    if (num == null || num.isEmpty()) {
      return num;
    }
    if (num.length() <= k) {
      return "0";
    }
    char[] chars = num.toCharArray();
    StringBuilder stack = new StringBuilder();
    stack.append(chars[0]);
    for (int i = 1; i < chars.length; i++) {
      char c = chars[i];
      while (!stack.isEmpty() && stack.charAt(stack.length() - 1) > c && k > 0) {
        stack.deleteCharAt(stack.length() - 1);
        k--;
      }
      stack.append(c);
    }
    for (int i = k; i > 0; i--) {
      stack.deleteCharAt(stack.length() - 1);
    }
    while (!stack.isEmpty() && stack.charAt(0) == '0') {
      stack.deleteCharAt(0);
    }
    return stack.isEmpty() ? "0" : stack.toString();
  }
  // end::answer[]
}
