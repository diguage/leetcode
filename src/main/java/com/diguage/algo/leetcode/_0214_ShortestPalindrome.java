package com.diguage.algo.leetcode;

public class _0214_ShortestPalindrome {
  // tag::answer[]

  /**
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
      int i = index;
      int j = 0;
      while (i < length && reversed.charAt(i) == s.charAt(j)) {
        i++;
        j++;
      }
      if (i == length) {
        break;
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
