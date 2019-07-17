package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 12. Integer to Roman
 *
 * https://leetcode.com/problems/integer-to-roman/[Integer to Roman - LeetCode]
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
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
 * Input: 3
 * Output: "III"
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 4
 * Output: "IV"
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: 9
 * Output: "IX"
 * ----
 *
 * .Example 4:
 * [source]
 * ----
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V= 5, III = 3.
 * ----
 *
 * .Example 5:
 * [source]
 * ----
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-07-17 10:45
 */
public class IntegerToRoman {
    /**
     * Runtime: 46 ms, faster than 5.34% of Java online submissions for Integer to Roman.
     *
     * Memory Usage: 44.1 MB, less than 5.01% of Java online submissions for Integer to Roman.
     *
     * @since 2019-07-17 11:24:02
     */
    public String intToRoman(int num) {
        Map<Integer, String> i2r = new HashMap<>(19);
        i2r.put(1, "I");
        i2r.put(5, "V");
        i2r.put(10, "X");
        i2r.put(50, "L");
        i2r.put(100, "C");
        i2r.put(500, "D");
        i2r.put(1000, "M");
        i2r.put(4, "IV");
        i2r.put(9, "IX");
        i2r.put(40, "XL");
        i2r.put(90, "XC");
        i2r.put(400, "CD");
        i2r.put(900, "CM");

        StringBuilder builder = new StringBuilder(20);

        int size = i2r.size();
        int temp = num;

        Integer[] keys = i2r.keySet().toArray(new Integer[0]);
        Arrays.sort(keys, Comparator.comparingInt(a -> -a));

        int lastIndex = 0;
        while (temp > 0) {
            for (int i = lastIndex; i < size; i++) {
                Integer key = keys[i];
                if (temp >= key) {
                    lastIndex = i;
                    temp -= key;
                    builder.append(i2r.get(key));
                    break;
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();

        String roman5 = solution.intToRoman(1994);
        System.out.println("MCMXCIV".equals(roman5) + " : " + roman5);


        String roman = solution.intToRoman(3);
        System.out.println("III".equals(roman) + " : " + roman);

        String roman2 = solution.intToRoman(4);
        System.out.println("IV".equals(roman2) + " : " + roman2);

        String roman3 = solution.intToRoman(9);
        System.out.println("IX".equals(roman3) + " : " + roman3);

        String roman4 = solution.intToRoman(58);
        System.out.println("LVIII".equals(roman4) + " : " + roman4);
    }
}
