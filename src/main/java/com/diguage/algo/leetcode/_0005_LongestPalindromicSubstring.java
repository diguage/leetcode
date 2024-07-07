package com.diguage.algo.leetcode;

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
public class _0005_LongestPalindromicSubstring {
  // tag::answer[]
  /**
   * Runtime: 1118 ms, faster than 5.01% of Java online submissions for Longest Palindromic Substring.
   *
   * Memory Usage: 37.2 MB, less than 94.36% of Java online submissions for Longest Palindromic Substring.
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2019-07-13 11:12
   */
  public String longestPalindromeBruteForce(String s) {
    if (Objects.isNull(s) || s.length() == 1) {
      return s;
    }
    int maxLength = 1;
    int begin = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      for (int j = i + 1; j < s.length(); j++) {
        // 这里要注意：先判断长度，然后执行回文判断，相当于做了剪枝操作，效率会提高很多。
        if (j - i + 1 > maxLength && isPalindrome(s, i, j)) {
          maxLength = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLength);
  }

  private boolean isPalindrome(String s, int low, int high) {
    while (low <= high) {
      if (s.charAt(low) != s.charAt(high)) {
        return false;
      }
      low++;
      high--;
    }
    return true;
  }

  public String longestPalindrome(String s) {
    if (Objects.isNull(s) || s.length() <= 1) {
      return s;
    }
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0005_LongestPalindromicSubstring solution = new _0005_LongestPalindromicSubstring();
    System.out.println("aaabaaa - " + solution.longestPalindrome("cbbd"));
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
