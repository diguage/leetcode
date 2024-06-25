package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 227. Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/[Basic Calculator II - LeetCode]
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: "3+2*2"
 * Output: 7
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: " 3/2 "
 * Output: 1
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: " 3+5 / 2 "
 * Output: 5
 * ----
 *
 * *Note:*
 *
 * * You may assume that the given expression is always valid.
 * * *Do not* use the `eval` built-in library function.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-19 23:30
 */
public class _0227_BasicCalculatorIi {
    /**
     * Runtime: 5 ms, faster than 98.92% of Java online submissions for Basic Calculator II.
     *
     * Memory Usage: 42.8 MB, less than 5.97% of Java online submissions for Basic Calculator II.
     *
     * Copy from: https://leetcode.com/problems/basic-calculator-ii/discuss/62996/Java-straight-forward-iteration-Solution-with-comments-No-Stack-O(N)-and-O(1)[Java straight forward iteration Solution with comments, No Stack, O(N) & O(1) - LeetCode Discuss]
     */
    public int calculate(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        int result = 0;
        long previous = 0;
        char operator = '+';

        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int value = c - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    value = value * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                if (operator == '+') {
                    result += previous;
                    previous = value;
                } else if (operator == '-') {
                    result += previous;
                    previous = -value;
                } else if (operator == '*') {
                    previous *= value;
                } else if (operator == '/') {
                    previous /= value;
                }
            } else {
                operator = c;
            }
        }
        result += previous;
        return result;
    }

    public static void main(String[] args) {
        _0227_BasicCalculatorIi solution = new _0227_BasicCalculatorIi();


        int r4 = solution.calculate("0-2147483647");
        System.out.println((r4 == -2147483647) + " : " + r4);

        int r1 = solution.calculate("3+2*2");
        System.out.println((r1 == 7) + " : " + r1);

        int r2 = solution.calculate(" 3/2 ");
        System.out.println((r2 == 1) + " : " + r2);

        int r3 = solution.calculate(" 3+5 / 2 ");
        System.out.println((r3 == 5) + " : " + r3);
    }
}
