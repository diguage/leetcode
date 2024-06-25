package com.diguage.algorithm.leetcode;

/**
 * = 202. Happy Number
 *
 * https://leetcode.com/problems/happy-number/[Happy Number - LeetCode]
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * .Example:
 * [source]
 * ----
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-10 21:40
 */
public class _0202_HappyNumber {
    /**
     * Runtime: 1 ms, faster than 99.99% of Java online submissions for Happy Number.
     *
     * Memory Usage: 33.4 MB, less than 10.60% of Java online submissions for Happy Number.
     *
     * Copy from: https://leetcode.com/problems/happy-number/discuss/56917/My-solution-in-C(-O(1)-space-and-no-magic-math-property-involved-)[My solution in C( O(1) space and no magic math property involved ) - LeetCode Discuss]
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    public int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        _0202_HappyNumber solution = new _0202_HappyNumber();
        boolean happy = solution.isHappy(19);
        System.out.println(happy);
    }
}
