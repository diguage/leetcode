package com.diguage.algo.leetcode;

public class _0214_ShortestPalindrome {
  // tag::answer[]

  /**
   * 优化：使用 reversed.substring(index) 代替逐个字母比较。
   * <p>
   * 优化前：通过 124 / 126 个测试用例，超时！
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-30 20:35:57
   */
  public String shortestPalindrome(String s) {
    String reversed = new StringBuilder(s).reverse().toString();
    if (reversed.equals(s)) {
      return s;
    }
    int index = 0;
    int length = s.length();
    while (index < length) {
      if (reversed.substring(index).equals(s.substring(0, length - index))) {
        return reversed.substring(0, index) + s;
      }
      index++;
    }
    return reversed.substring(0, index) + s;
  }
  // end::answer[]

  public static void main(String[] args) {
    System.out.println(new _0214_ShortestPalindrome().shortestPalindrome("abcd"));
  }
}
