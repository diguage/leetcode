package com.diguage.algo.leetcode;

public class _0709_ToLowerCase {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-23 22:45:46
   */
  public String toLowerCase(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if ('A' <= c && c <= 'Z') {
        chars[i] = (char) ('a' + c - 'A');
      }
    }
    return new String(chars);
  }
  // end::answer[]
}
