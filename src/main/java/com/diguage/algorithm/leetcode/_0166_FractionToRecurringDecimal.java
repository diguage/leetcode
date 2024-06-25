package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * = 166. Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/[Fraction to Recurring Decimal - LeetCode]
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-11 13:14
 */
public class _0166_FractionToRecurringDecimal {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Fraction to Recurring Decimal.
     *
     * Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Fraction to Recurring Decimal.
     *
     * Copy from: https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution[My clean Java solution - LeetCode Discuss]
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        result.append(numerator > 0 ^ denominator > 0 ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        if (num > den) {
            result.append(num / den);
        } else {
            result.append("0");
        }
        num %= den;
        if (num == 0) {
            return result.toString();
        }
        result.append(".");
        Map<Long, Integer> numToIndexMap = new HashMap<>();
        // 这里需要注意，在 Map 中放的是被除数，而不是计算出来的位数digit。
        numToIndexMap.put(num, result.length());
        while (num != 0) {
            num *= 10;
            result.append(num / den);
            num %= den;
            if (numToIndexMap.containsKey(num)) {
                Integer index = numToIndexMap.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                numToIndexMap.put(num, result.length());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        _0166_FractionToRecurringDecimal solultion = new _0166_FractionToRecurringDecimal();
        String r4 = solultion.fractionToDecimal(1, 333);
        System.out.println("0.(003)".equals(r4) + " : " + r4);

        String r3 = solultion.fractionToDecimal(2, 1);
        System.out.println("2".equals(r3) + " : " + r3);

        String r1 = solultion.fractionToDecimal(1, 2);
        System.out.println("0.5".equals(r1) + " : " + r1);

        String r2 = solultion.fractionToDecimal(-8, 7);
        System.out.println("-1.(142857)".equals(r2) + " : " + r2);
    }
}
