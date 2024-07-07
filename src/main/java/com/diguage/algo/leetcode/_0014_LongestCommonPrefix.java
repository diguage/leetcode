package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 14. Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/[Longest Common Prefix - LeetCode]
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * .Example 1:
 * [source]
 * ----
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * ----
 *
 * *Note:*
 *
 * All given inputs are in lowercase letters `a-z`.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-07-11 17:50
 */
public class _0014_LongestCommonPrefix {
  // tag::answer[]

  /**
   * 使用逐列扫描前进，遇到不同时，则终止。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2019-07-11 17:50
   */
  public String longestCommonPrefix(String[] strs) {
    if (Objects.isNull(strs) || strs.length == 0) {
      return "";
    }
    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }

  public String longestCommonPrefix2(String[] strs) {
    if (Objects.isNull(strs) || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }
    int maxLength = Integer.MAX_VALUE;
    for (String str : strs) {
      int strLength = str.length();
      if (strLength < maxLength) {
        maxLength = strLength;
      }
    }

    int length = 0;

    loop:
    while (length < maxLength) {
      char aChar = strs[0].charAt(length);
      for (int i = 1; i < strs.length; i++) {
        char bChar = strs[i].charAt(length);
        if (aChar != bChar) {
          break loop;
        }
      }
      length += 1;
    }
    if (length > 0) {
      return strs[0].substring(0, length);
    } else {
      return "";
    }
  }

  // end::answer[]


  public static void main(String[] args) {
    _0014_LongestCommonPrefix prefix = new _0014_LongestCommonPrefix();
    String prefix1 = prefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    System.out.println("fl".equals(prefix1) + " " + prefix1);
    System.out.println("".equals(prefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"})));
  }
}
