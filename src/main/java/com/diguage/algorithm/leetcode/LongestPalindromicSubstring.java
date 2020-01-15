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
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-07-13 11:12
 */
public class LongestPalindromicSubstring {
    /**
     * Runtime: 1118 ms, faster than 5.01% of Java online submissions for Longest Palindromic Substring.
     *
     * Memory Usage: 37.2 MB, less than 94.36% of Java online submissions for Longest Palindromic Substring.
     */
    public String longestPalindrome(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return "";
        }
        int length = s.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isPalindrome(s, i, j)) {
                    String substring = s.substring(i, j + 1);
                    if (substring.length() > result.length()) {
                        result = substring;
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start < end) {
            char sChar = s.charAt(start);
            char eChar = s.charAt(end);
            if (sChar != eChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
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