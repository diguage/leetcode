package com.diguage.algo.leetcode;

public class _0005_LongestPalindromicSubstring_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-05 23:47:51
   */
  public String longestPalindrome(String s) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      String p = getPalindrome(s, i);
      if (result.length() < p.length()) {
        result = p;
      }
    }
    return result;
  }

  private String getPalindrome(String s, int idx) {
    String result = "";
    int l = idx, r = idx;
    while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
      if (result.length() < r - l + 1) {
        result = s.substring(l, r + 1);
      }
      l--;
      r++;
    }
    l = idx;
    r = idx + 1;
    while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
      if (result.length() < r - l + 1) {
        result = s.substring(l, r + 1);
      }
      l--;
      r++;
    }
    return result;
  }

//  /**
//   * 可以从两头判断：如果两头相等，则判断是否为回文，如果是中止循环。
//   *
//   * 可惜效率并不高。
//   */
//  private String getPalindrome(String s, int idx) {
//    String result = "";
//    int len = Math.min(idx - 0, s.length() - idx - 1);
//    int l = idx - len, r = idx + len;
//    while (l <= r) {
//      if (s.charAt(l) == s.charAt(r) && isPalindrome(s, l, r)) {
//        break;
//      }
//      l++;
//      r--;
//    }
//    result = s.substring(l, r + 1);
//    len = Math.min(idx - 0, (s.length() - 1) - (idx + 1));
//    l = idx - len;
//    r = idx + 1 + len;
//    while (l < r) {
//      if (s.charAt(l) == s.charAt(r) && isPalindrome(s, l, r)) {
//        break;
//      }
//      l++;
//      r--;
//    }
//    if (result.length() < r - l + 1) {
//      result = s.substring(l, r + 1);
//    }
//    return result;
//  }
//
//  private boolean isPalindrome(String s, int left, int ritht) {
//    while (left < ritht) {
//      if (s.charAt(left++) != s.charAt(ritht--)) {
//        return false;
//      }
//    }
//    return true;
//  }
  // end::answer[]
}
