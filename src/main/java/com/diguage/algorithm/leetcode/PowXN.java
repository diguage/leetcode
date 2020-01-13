package com.diguage.algorithm.leetcode;

/**
 * = 50. Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/[Pow(x, n) - LeetCode]
 *
 * Implement `pow(x, n)`, which calculates x raised to the power n (x^n^).
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 2.00000, 10
 * Output: 1024.00000
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 2.10000, 3
 * Output: 9.26100
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * ----
 *
 * *Note:*
 *
 * * `-100.0 < x < 100.0`
 * * n is a 32-bit signed integer, within the range [−2^31^, 2^31^ − 1]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-13 21:19
 */
public class PowXN {

    /**
     * Runtime: 1 ms, faster than 94.10% of Java online submissions for Pow(x, n).
     *
     * Memory Usage: 34.4 MB, less than 5.88% of Java online submissions for Pow(x, n).
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double semiResult = myPow(x, n / 2);
        if (Double.isInfinite(semiResult)) {
            return 0.0;
        }

        return (n % 2 == 0 ? 1.0 : x) * semiResult * semiResult;
    }

    /**
     * Time Limit Exceeded
     * <p>
     * Copy from:
     */
    public double myPowTimeout(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPowTimeout(x, n / 2) * myPowTimeout(x, n / 2)
                : x * myPowTimeout(x, n / 2) * myPowTimeout(x, n / 2);
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        double r1 = solution.myPow(2.0, -2);
        System.out.println(r1);

        double r2 = solution.myPow(2.1, 3);
        System.out.println(r2);

        double r3 = solution.myPow(-2.1, 3);
        System.out.println(r3);

        double r4 = solution.myPow(2, Integer.MIN_VALUE);
        System.out.println(r4);
    }
}
