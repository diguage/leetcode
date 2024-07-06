package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
 * @since 2019-07-11 21:31
 */
public class _0003_LongestSubstringWithoutRepeatingCharacters {
  // tag::answer[]
  /**
   * Runtime: 6 ms, faster than 85.45% of Java online submissions for Longest Substring Without Repeating Characters.
   *
   * Memory Usage: 36.4 MB, less than 99.80% of Java online submissions for Longest Substring Without Repeating Characters.
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2019-07-11 21:31
   */
  public int lengthOfLongestSubstring(String s) {
    if (Objects.isNull(s) || s.length() == 0) {
      return 0;
    }
    int result = 0;
    int length = s.length();
    Map<Character, Integer> charToIndexMap = new HashMap<>(length * 4 / 3);
    for (int i = 0, j = 0; j < length; j++) {
      char aChar = s.charAt(j);
      if (charToIndexMap.containsKey(aChar)) {
        // 这里，如果存在重复的，则从上一个重复字符的下一个字符开始计算。
        Integer index = charToIndexMap.get(aChar);
        if (index + 1 > i) {
          i = index + 1;
        }
      }
      charToIndexMap.put(aChar, j);
      if (j - i + 1 > result) {
        result = j - i + 1;
      }

    }
    return result;
  }

  /**
   * Runtime: 9 ms, faster than 49.55% of Java online submissions for Longest Substring Without Repeating Characters.
   *
   * Memory Usage: 36 MB, less than 99.88% of Java online submissions for Longest Substring Without Repeating Characters.
   */
  public int lengthOfLongestSubstringWithSlidingWindow(String s) {
    if (Objects.isNull(s) || s.length() == 0) {
      return 0;
    }
    int result = 0;
    int length = s.length();
    int head = 0;
    int tail = 0;
    Set<Character> characters = new HashSet<>(length * 4 / 3);
    while (head < length && tail < length) {
      if (!characters.contains(s.charAt(tail))) {
        characters.add(s.charAt(tail));
        tail++;
        if (result < tail - head) {
          result = tail - head;
        }
      } else {
        characters.remove(s.charAt(head));
        head++;
      }
    }
    return result;
  }

  /**
   * Runtime: 221 ms, faster than 5.02% of Java online submissions for Longest Substring Without Repeating Characters.
   *
   * Memory Usage: 37.3 MB, less than 97.43% of Java online submissions for Longest Substring Without Repeating Characters.
   */
  public int lengthOfLongestSubstringWithBruteForce(String s) {
    if (Objects.isNull(s) || s.length() == 0) {
      return 0;
    }
    char[] chars = s.toCharArray();
    int result = 0;
    for (int i = 0; i < chars.length; i++) {
      Set<Character> characters = new HashSet<>(chars.length * 4 / 3);
      for (int j = i; j < chars.length; j++) {
        char aChar = chars[j];
        if (characters.contains(aChar)) {
          break;
        } else {
          characters.add(aChar);
        }
      }
      if (characters.size() > result) {
        result = characters.size();
      }
    }
    return result;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0003_LongestSubstringWithoutRepeatingCharacters result = new _0003_LongestSubstringWithoutRepeatingCharacters();
    System.out.println("2 - " + result.lengthOfLongestSubstring("aab"));
    System.out.println("3 - " + result.lengthOfLongestSubstring("abcabcbb"));
    System.out.println("1 - " + result.lengthOfLongestSubstring("bbbbb"));
    System.out.println("3 - " + result.lengthOfLongestSubstring("pwwkew"));
  }
}
