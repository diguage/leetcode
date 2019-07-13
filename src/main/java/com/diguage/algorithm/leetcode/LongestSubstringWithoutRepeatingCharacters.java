package com.diguage.algorithm.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * = 3. Longest Substring Without Repeating Characters
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/[Longest Substring Without Repeating Characters - LeetCode]
 * <p>
 * Given a string, find the length of the *longest substring* without repeating characters.
 * <p>
 * .Example 1:
 * [source]
 * ----
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * ----
 * <p>
 * .Example 2:
 * [source]
 * ----
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * ----
 * <p>
 * .Example 3:
 * [source]
 * ----
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-07-11 21:31
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Runtime: 9 ms, faster than 49.55% of Java online submissions for Longest Substring Without Repeating Characters.
     * <p>
     * Memory Usage: 36 MB, less than 99.88% of Java online submissions for Longest Substring Without Repeating Characters.
     */
    public int lengthOfLongestSubstring(String s) {
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
     * <p>
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

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters result = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("2 - " + result.lengthOfLongestSubstring("aab"));
        System.out.println("3 - " + result.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("1 - " + result.lengthOfLongestSubstring("bbbbb"));
        System.out.println("3 - " + result.lengthOfLongestSubstring("pwwkew"));
    }
}
