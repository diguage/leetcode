package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 125. Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/[Valid Palindrome - LeetCode]
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * *Note:* For the purpose of this problem, we define empty string as valid palindrome.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "race a car"
 * Output: false
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-14 23:34
 */
public class _0125_ValidPalindrome {
    /**
     * Runtime: 3 ms, faster than 96.33% of Java online submissions for Valid Palindrome.
     *
     * Memory Usage: 38.3 MB, less than 76.78% of Java online submissions for Valid Palindrome.
     */
    public boolean isPalindrome(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if (!isAlphanumberic(lc)) {
                left++;
            } else if (!isAlphanumberic(rc)) {
                right--;
            } else {
                if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isAlphanumberic(char aChar) {
        return ('a' <= aChar && aChar <= 'z') || ('A' <= aChar && aChar <= 'Z')
                || ('0' <= aChar && aChar <= '9');
    }


    public static void main(String[] args) {
        _0125_ValidPalindrome solution = new _0125_ValidPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }
}
