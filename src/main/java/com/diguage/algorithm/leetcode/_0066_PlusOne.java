package com.diguage.algorithm.leetcode;

import java.util.Arrays;

/**
 * = 66. Plus One
 *
 * https://leetcode.com/problems/plus-one/description/[Plus One - LeetCode]
 *
 * Given a *non-empty* array of digits representing a non-negative integer,
 * plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the
 * head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except
 * the number 0 itself.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-07-14 15:30
 */
public class _0066_PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{4, 3, 2, 1};
        int[] a2 = new int[]{9, 9, 9};
        int[] a3 = new int[]{9, 9, 8};
        System.out.println(Arrays.toString(plusOne(a1)));
        System.out.println(Arrays.toString(plusOne(a2)));
        System.out.println(Arrays.toString(plusOne(a3)));
    }
}
