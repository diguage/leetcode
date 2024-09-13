package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 242. Valid Anagram
 *
 * Given two strings `s` and `t` , write a function to determine if `t` is an anagram of `s`.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: s = "rat", t = "car"
 * Output: false
 * ----
 *
 * *Note:*
 * You may assume the string contains only lowercase alphabets.
 *
 * *Follow up:*
 *
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-10 23:48
 */
public class _0242_ValidAnagram {
  // tag::answer[]
    /**
     * Runtime: 3 ms, faster than 93.97% of Java online submissions for Valid Anagram.
     *
     * Memory Usage: 36.2 MB, less than 98.06% of Java online submissions for Valid Anagram.
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-10 23:48
     */
    public boolean isAnagram(String s, String t) {
        if (Objects.isNull(s) && Objects.isNull(t)) {
            return true;
        }
        if (Objects.isNull(s) || Objects.isNull(t)) {
            return false;
        }
        int[] sChartCount = new int[26];
        for (char c : s.toCharArray()) {
            sChartCount[c - 'a']++;
        }
        int[] tChartCount = new int[26];
        for (char c : t.toCharArray()) {
            tChartCount[c - 'a']++;
        }
        return Arrays.equals(sChartCount, tChartCount);
    }

    /**
     * Runtime: 3 ms, faster than 93.97% of Java online submissions for Valid Anagram.
     *
     * Memory Usage: 37.9 MB, less than 64.51% of Java online submissions for Valid Anagram.
     */
    public boolean isAnagramSort(String s, String t) {
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0242_ValidAnagram solution = new _0242_ValidAnagram();
        boolean r1 = solution.isAnagram("anagram", "nagaram");
        System.out.println(r1);

        boolean r2 = solution.isAnagram("rat", "car");
        System.out.println(r2);
    }
}
