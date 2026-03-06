package com.diguage.algo.leetcode;

public class _0541_ReverseStringIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-06 21:35:12
   */
  public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i += 2 * k) {
      int left = i, right = Math.min(i + k, s.length()) - 1;
      while (left < right) {
        char c = chars[left];
        chars[left] = chars[right];
        chars[right] = c;
        left++;
        right--;
      }
    }
    return new String(chars);
  }
  // end::answer[]
  static void main() {
    new _0541_ReverseStringIi().reverseStr("abcdefg", 2);
  }
}
