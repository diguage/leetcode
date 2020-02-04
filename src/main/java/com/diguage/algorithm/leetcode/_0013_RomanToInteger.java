package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * = 13. Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/[Roman to Integer - LeetCode]
 *
 * Roman numerals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D` and `M`.
 *
 * [source]
 * ----
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ----
 *
 * For example, two is written as `II` in Roman numeral, just two one's added together.
 * Twelve is written as, `XII`, which is simply `X` + `II`. The number twenty seven is
 * written as XXVII, which is `XX` + `V` + `II`.
 *
 * Roman numerals are usually written largest to smallest from left to right. However,
 * the numeral for four is not `IIII`. Instead, the number four is written as `IV`.
 * Because the one is before the five we subtract it making four. The same principle
 * applies to the number nine, which is written as `IX`. There are six instances
 * where subtraction is used:
 *
 * * `I` can be placed before `V` (5) and `X` (10) to make 4 and 9.
 * * `X` can be placed before `L` (50) and `C` (100) to make 40 and 90.
 * * `C` can be placed before `D` (500) and `M` (1000) to make 400 and 900.
 *
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: "III"
 * Output: 3
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "IV"
 * Output: 4
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: "IX"
 * Output: 9
 * ----
 *
 * .Example 4:
 * [source]
 * ----
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * ----
 *
 * .Example 5:
 * [source]
 * ----
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-07-11 17:14
 */
public class _0013_RomanToInteger {

    public int romanToInt(String s) {
        int result = 0;
        if (Objects.isNull(s) || s.length() == 0) {
            return result;
        }

        HashMap<String, Integer> r2i = new HashMap<>();
        r2i.put("I", 1);
        r2i.put("V", 5);
        r2i.put("X", 10);
        r2i.put("L", 50);
        r2i.put("C", 100);
        r2i.put("D", 500);
        r2i.put("M", 1000);
        r2i.put("IV", 4);
        r2i.put("IX", 9);
        r2i.put("XL", 40);
        r2i.put("XC", 90);
        r2i.put("CD", 400);
        r2i.put("CM", 900);

        for (int i = s.length(); i > 0; ) {
            int step = 2;
            int beginIndex = i - step;
            if (beginIndex < 0) {
                beginIndex = 0;
            }
            String symbol = s.substring(beginIndex, i);
            Integer value = r2i.get(symbol);
            if (Objects.isNull(value)) {
                step = 1;
                beginIndex = i - step;
                if (beginIndex < 0) {
                    beginIndex = 0;
                }
                symbol = s.substring(beginIndex, i);
                value = r2i.get(symbol);
            }
            result += value;
            i -= step;
        }
        return result;
    }

    public static void main(String[] args) {
        _0013_RomanToInteger roman = new _0013_RomanToInteger();
        System.out.println(roman.romanToInt("III") == 3);
        System.out.println(roman.romanToInt("IV") == 4);
        System.out.println(roman.romanToInt("IX") == 9);
        System.out.println(roman.romanToInt("LVIII") == 58);
        System.out.println(roman.romanToInt("MCMXCIV") == 1994);
    }
}
