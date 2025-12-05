package com.diguage.algo.leetcode;

public class _0005_LongestPalindromicSubstring_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-05 21:52:24
   */
  public String longestPalindrome(String s) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      String palindrome = longestPalindrome(s, i);
      if (palindrome.length() > result.length()) {
        result = palindrome;
      }
    }
    return result;
  }

  private String longestPalindrome(String s, int mid) {
    String result = "";
    for (int i = 0; i <= mid && mid + i < s.length(); i++) {
      int left = mid - i;
      int right = mid + i;
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }
      if (result.length() < (right - left + 1)) {
        result = s.substring(left, right + 1);
      }
    }
    for (int i = 0; i <= mid && mid + 1 + i < s.length(); i++) {
      int left = mid - i;
      int right = mid + 1 + i;
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }
      if (result.length() < (right - left + 1)) {
        result = s.substring(left, right + 1);
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0005_LongestPalindromicSubstring_5()
//      .longestPalindrome("babad");
      .longestPalindrome("bb");
  }
}
