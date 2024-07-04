package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 5. Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/[Longest Palindromic Substring - LeetCode]
 *
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "cbbd"
 * Output: "bb"
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-07-13 11:12
 */
public class _0005_LongestPalindromicSubstring_2 {
  /**
   * 自己实现
   */
  public String longestPalindrome(String s) {
    if (Objects.isNull(s) || s.length() == 1) {
      return s;
    }
    int left = -1, right = -2;
    for (int i = 0; i < s.length(); i++) {
      boolean p1 = true;
      boolean p2 = true;
      for (int j = 0; j <= i; j++) {
        char c1 = s.charAt(i - j);
        // aba 型
        if (p1 && i + j < s.length()) {
          char c2 = s.charAt(i + j);
          if (c1 == c2) {
            if ((i + j) - (i - j) > right - left) {
              left = i - j;
              right = i + j;
            }
          } else {
            p1 = false;
          }
        }
        // aa 型
        if (p2 && i + 1 + j < s.length()) {
          char c2 = s.charAt(i + 1 + j);
          if (c2 == c1) {
            if ((i + 1 + j) - (i - j) > right - left) {
              left = i - j;
              right = i + 1 + j;
            }
          } else {
            p2 = false;
          }
        }
        if (!p1 && !p2) {
          break;
        }
      }
    }
    return left >= 0 ? s.substring(left, right + 1) : null;
  }

  public static void main(String[] args) {
    _0005_LongestPalindromicSubstring_2 solution = new _0005_LongestPalindromicSubstring_2();
//    System.out.println("cbbd - " + solution.longestPalindrome("cbbd"));
    System.out.println("aaabaaa - " + solution.longestPalindrome("aaabaaaa"));
    System.out.println("ccc - " + solution.longestPalindrome("ccc"));
    System.out.println("a - " + solution.longestPalindrome("abcda"));
    System.out.println("abcba - " + solution.longestPalindrome("abcba"));
    System.out.println("a - " + solution.longestPalindrome("ac"));
    System.out.println("bab - " + solution.longestPalindrome("babad"));
    System.out.println("bb  - " + solution.longestPalindrome("cbbd"));
    System.out.println("bb  - " + solution.longestPalindrome("abbc"));
    System.out.println("a - " + solution.longestPalindrome("a"));
  }
}
