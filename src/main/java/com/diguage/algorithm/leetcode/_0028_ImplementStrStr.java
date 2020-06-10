package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 28. Implement strStr()
 *
 * Implement `strStr()`.
 *
 * Return the index of the first occurrence of needle in haystack, or *-1* if needle is not part of haystack.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * ----
 *
 * *Clarification:*
 *
 * What should we return when `needle` is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's `strstr()`
 * and Java's `indexOf()`.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018
 */
public class _0028_ImplementStrStr {
  public int strStr(String haystack, String needle) {
    if (Objects.isNull(needle) || needle.length() == 0) {
      return 0;
    }
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        String sub = haystack.substring(i, i + needle.length());
        if (needle.equals(sub)) {
          return i;
        }
      }
    }
    return -1;
  }

  // TODO 有必要学一下 KMP 算法了啊！
  public int strStr1(String source, String target) {
    if (source == null || target == null || target.length() > source.length()) {
      return -1;
    }
    if (target.length() == 0) {
      return 0;
    }
    char[] sA = source.toCharArray();
    char[] tA = target.toCharArray();
    for (int i = 0; i < source.length(); i++) {
      if (contain(sA, i, tA)) {
        return i;
      }
    }
    return -1;
  }

  private boolean contain(char[] source, int index, char[] target) {
    if (source.length - index < target.length) {
      return false;
    }
    for (int i = index, j = 0; j < target.length; i++, j++) {
      if (source[i] != target[j]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    _0028_ImplementStrStr result = new _0028_ImplementStrStr();
    System.out.println(result.strStr("a", "a"));
    System.out.println(result.strStr("hello", "ll"));
    System.out.println(result.strStr("aaaaa", "bba"));
  }
}
