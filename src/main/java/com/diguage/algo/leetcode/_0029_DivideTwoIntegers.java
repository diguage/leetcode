package com.diguage.algo.leetcode;

/**
 * = 29. Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/[Divide Two Integers - LeetCode]
 *
 * Given two integers `dividend` and `divisor`, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing `dividend` by `divisor`.
 *
 * The integer division should truncate toward zero.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * ----
 *
 * *Note:*
 *
 * * Both dividend and divisor will be 32-bit signed integers.
 * * The divisor will never be 0.
 * * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31^,  2^31^ − 1]. For the purpose of this problem, assume that your function returns 2^31^ − 1 when the division result overflows.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-14 16:46
 */
public class _0029_DivideTwoIntegers {
  // tag::answer[]
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Divide Two Integers.
     *
     * Memory Usage: 34.3 MB, less than 6.06% of Java online submissions for Divide Two Integers.
     *
     * Copy from: https://leetcode.com/problems/divide-two-integers/discuss/13407/C%2B%2B-bit-manipulations[C++ bit manipulations - LeetCode Discuss]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-14 16:46
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        int result = 0;
        while (ldividend >= ldivisor) {
            long temp = ldivisor;
            int mul = 1;
            while (temp << 1 <= ldividend) {
                temp <<= 1;
                mul <<= 1;
            }
            ldividend -= temp;
            result += mul;
        }
        return result * sign;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0029_DivideTwoIntegers solution = new _0029_DivideTwoIntegers();
        int r1 = solution.divide(10, 3);
        System.out.println((r1 == 3) + " : " + r1);

        int r2 = solution.divide(7, -3);
        System.out.println((r2 == -2) + " : " + r2);

        int r3 = solution.divide(2147483647, 1);
        System.out.println((r3 == 2147483647) + " : " + r3);

        int r4 = solution.divide(2147483647, 2);
        System.out.println((r4 == 1073741823) + " : " + r4);
    }
}
