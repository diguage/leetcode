package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 9. Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/[Palindrome Number - LeetCode]
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 121
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * ----
 *
 * == Follow up
 *
 * Coud you solve it without converting the integer to a string?
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-07-01
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        boolean result = true;
        if (x < 0) {
            return false;
        }
        int multiBitNumStarter = 10;
        if (x < multiBitNumStarter) {
            return result;
        }
        List<Integer> bitNums = new ArrayList<>(25);
        for (int i = x; i > 0; i /= 10) {
            bitNums.add(i % 10);
        }
        int halfLength = bitNums.size() / 2;
        for (int i = 0; i < halfLength; i++) {
            if (!bitNums.get(i).equals(bitNums.get(bitNums.size() - i - 1))) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
