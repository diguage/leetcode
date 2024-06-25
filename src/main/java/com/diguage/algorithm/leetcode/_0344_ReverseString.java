package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 344. Reverse String
 *
 * https://leetcode.com/problems/reverse-string/[Reverse String - LeetCode]
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by *modifying the input array* in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 * .Example 2:
 * [source]
 * ----
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]\
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-15 00:03
 */
public class _0344_ReverseString {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse String.
     *
     * Memory Usage: 52.7 MB, less than 5.33% of Java online submissions for Reverse String.
     */
    public void reverseString(char[] s) {
        if (Objects.isNull(s) || s.length == 0) {
            return;
        }
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) {
        _0344_ReverseString solution = new _0344_ReverseString();
        char[] c1 = "hello".toCharArray();
        solution.reverseString(c1);
        System.out.println(new String(c1));
    }
}
