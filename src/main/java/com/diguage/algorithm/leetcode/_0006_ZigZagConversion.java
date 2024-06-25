package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 6. ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/[ZigZag Conversion - LeetCode]
 *
 * The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 *
 * [source]
 * ----
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * ----
 *
 * And then read line by line: `"PAHNAPLSIIGYIR"`
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * [source]
 * ----
 * string convert(string s, int numRows);
 * ----
 *
 * .Example 1:
 * [source]
 * ----
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-07-14 18:20
 */
public class _0006_ZigZagConversion {
    /**
     * Runtime: 5 ms, faster than 73.81% of Java online submissions for ZigZag Conversion.
     *
     * Memory Usage: 38.7 MB, less than 77.68% of Java online submissions for ZigZag Conversion.
     */
    public String convert(String s, int numRows) {
        if (Objects.isNull(s) || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        int columnLength = length / numRows;

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder(columnLength);
        }

        int direction = 1;
        int selector = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (selector == 0) {
                direction = 1;
            }
            if (selector == numRows - 1) {
                direction = -1;
            }
            char aChar = chars[i];
            builders[selector].append(aChar);
            selector += direction;
        }

        StringBuilder result = new StringBuilder(length);
        for (StringBuilder builder : builders) {
            result.append(builder);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        _0006_ZigZagConversion solution = new _0006_ZigZagConversion();

        String example3 = solution.convert("AB", 1);
        System.out.println(example3 + " " + "AB".equals(example3));

        String example1 = solution.convert("PAYPALISHIRING", 3);
        System.out.println(example1 + " " + "PAHNAPLSIIGYIR".equals(example1));

        String example2 = solution.convert("PAYPALISHIRING", 4);
        System.out.println(example2 + " " + "PINALSIGYAHRPI".equals(example2));
    }
}
