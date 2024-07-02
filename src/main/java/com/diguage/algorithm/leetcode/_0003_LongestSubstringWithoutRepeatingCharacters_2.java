package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 3. Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/[Longest Substring Without Repeating Characters - LeetCode]
 *
 * Given a string, find the length of the *longest substring* without repeating characters.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 19:27:43
 */
public class _0003_LongestSubstringWithoutRepeatingCharacters_2 {
  /**
   * 有思路，写不出代码
   */
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int result = Integer.MIN_VALUE;
    Map<Character, Integer> window = new HashMap<>();
    int left = 0, right = 0;
    while (right < s.length()) {
      char rc = s.charAt(right);
      right++;
      window.put(rc, window.getOrDefault(rc, 0) + 1);

      while (window.get(rc) > 1) {
        char lc = s.charAt(left);
        left++;
        window.put(lc, window.getOrDefault(lc, 0) - 1);
      }
      result = Math.max(result, right - left);
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }

  public static void main(String[] args) {
    _0003_LongestSubstringWithoutRepeatingCharacters_2 result = new _0003_LongestSubstringWithoutRepeatingCharacters_2();
    System.out.println("2 - " + result.lengthOfLongestSubstring("aab"));
    System.out.println("3 - " + result.lengthOfLongestSubstring("abcabcbb"));
    System.out.println("1 - " + result.lengthOfLongestSubstring("bbbbb"));
    System.out.println("3 - " + result.lengthOfLongestSubstring("pwwkew"));
  }
}
