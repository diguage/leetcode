package com.diguage.algorithm.leetcode;

import java.util.Arrays;

/**
 * = 179. Largest Number
 *
 * https://leetcode.com/problems/largest-number/[Largest Number - LeetCode]
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [10,2]
 * Output: "210"
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * ----
 *
 * *Note:* The result may be very large, so you need to return a string instead of an integer.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-25 22:29
 */
public class _0179_LargestNumber {
    /**
     * Runtime: 21 ms, faster than 6.20% of Java online submissions for Largest Number.
     *
     * Memory Usage: 40.9 MB, less than 6.67% of Java online submissions for Largest Number.
     */
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });

        if ("0".equals(strings[0])) {
            return "0";
        }

        return String.join("", strings);
    }

    public static void main(String[] args) {
        _0179_LargestNumber solution = new _0179_LargestNumber();
        int[] n3 = {121, 12};
        String r3 = solution.largestNumber(n3);
        System.out.println("12121".equals(r3) + " : " + r3);

        int[] n1 = {10, 2};
        String r1 = solution.largestNumber(n1);
        System.out.println("210".equals(r1) + " : " + r1);

        int[] n2 = {3, 30, 34, 5, 9};
        String r2 = solution.largestNumber(n2);
        System.out.println("9534330".equals(r2) + " : " + r2);
    }
}
