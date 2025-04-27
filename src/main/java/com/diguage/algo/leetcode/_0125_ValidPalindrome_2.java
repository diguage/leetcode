package com.diguage.algo.leetcode;

public class _0125_ValidPalindrome_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-27 23:28:48
   */
  public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left <= right) {
      if (!isAlphanum(s.charAt(left))) {
        left++;
      } else if (!isAlphanum(s.charAt(right))) {
        right--;
      } else {
        if (Character.toLowerCase(s.charAt(left))
          != Character.toLowerCase(s.charAt(right))) {
          return false;
        }
        left++;
        right--;
      }
    }
    return true;
  }

  private boolean isAlphanum(char c) {
    return Character.isAlphabetic(c) || Character.isDigit(c);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0125_ValidPalindrome_2()
      .isPalindrome("0P");
  }
}
