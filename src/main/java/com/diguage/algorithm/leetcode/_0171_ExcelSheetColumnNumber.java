package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 171. Excel Sheet Column Number
 *
 * https://leetcode.com/problems/excel-sheet-column-number/[Excel Sheet Column Number - LeetCode]
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 * ----
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * ----
 *
 * .Example 1:
 * [source]
 * ----
 * Input: "A"
 * Output: 1
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "AB"
 * Output: 28
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: "ZY"
 * Output: 701
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-14 00:12
 */
public class _0171_ExcelSheetColumnNumber {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
     *
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Excel Sheet Column Number.
     */
    public int titleToNumber(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int base = 1;
        int result = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            result += (chars[i] - 'A' + 1) * base;
            base *= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        _0171_ExcelSheetColumnNumber solution = new _0171_ExcelSheetColumnNumber();
        int r1 = solution.titleToNumber("AA");
        System.out.println((r1 == 27) + " : " + r1);

        int r2 = solution.titleToNumber("ZY");
        System.out.println((r2 == 701) + " : " + r2);
    }
}
