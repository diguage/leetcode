package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 7. Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/[Reverse Integer - LeetCode]
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 123
 * Output: 321
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: -123
 * Output: -321
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: 120
 * Output: 21
 * ----
 *
 * == Note
 *
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-07-01
 */
public class ReverseInteger {
    public static int reverse(int x) {
        if (x == 0
                || x > Math.pow(2, 31)
                || x < -Math.pow(2, 31)) {
            return 0;
        }

        int sign = 1;
        int positiveNum = x;
        if (x < 0) {
            sign = -1;
            positiveNum = x * sign;
        }

        boolean zeroOfEnd = true;
        List<Integer> bitNums = new ArrayList<>(25);
        for (int i = positiveNum; i > 0; ) {
            int bitNum = i % 10;
            i = i / 10;
            if (zeroOfEnd && bitNum == 0) {
                continue;
            }
            bitNums.add(bitNum);
            if (zeroOfEnd) {
                zeroOfEnd = false;
            }
        }

        long result = 0;
        for (int j = 0; j < bitNums.size(); j++) {
            result += bitNums.get(j) * ((long) Math.pow(10, bitNums.size() - j - 1));
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result * sign;
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(-10305));
        int i = 1534236469;
        System.out.println(reverse(i));
        System.out.println(Integer.bitCount(i));
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
