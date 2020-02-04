package com.diguage.algorithm.leetcode;

/**
 * = 69. Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/[Sqrt(x) - LeetCode]
 *
 * Implement int `sqrt(int x)`.
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 4
 * Output: 2
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-13 22:30
 */
public class _0069_SqrtX {
    /**
     * Runtime: 2 ms, faster than 14.88% of Java online submissions for Sqrt(x).
     *
     * Memory Usage: 34.1 MB, less than 5.00% of Java online submissions for Sqrt(x).
     *
     * Copy from: https://leetcode.com/problems/sqrtx/discuss/25047/A-Binary-Search-Solution[A Binary Search Solution - LeetCode Discuss]
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (true) {
            int mid = left + (right - left) / 2;

            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        _0069_SqrtX solution = new _0069_SqrtX();

        int r5 = solution.mySqrt(9);
        System.out.println((r5 == 3) + " : " + r5);

        int r4 = solution.mySqrt(1024);
        System.out.println((r4 == 32) + " : " + r4);

        int r1 = solution.mySqrt(2);
        System.out.println((r1 == 1) + " : " + r1);

        int r2 = solution.mySqrt(8);
        System.out.println((r2 == 2) + " : " + r2);

        int r3 = solution.mySqrt(1);
        System.out.println((r3 == 1) + " : " + r3);
    }
}
