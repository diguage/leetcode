package com.diguage.algo.leetcode;

/**
 * = 326. Power of Three
 *
 * https://leetcode.com/problems/power-of-three/[Power of Three - LeetCode]
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 27
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 0
 * Output: false
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: 9
 * Output: true
 * ----
 *
 * .Example 4:
 * [source]
 * ----
 * Input: 45
 * Output: false
 * ----
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-14 22:54
 */
public class _0326_PowerOfThree {
  // tag::answer[]
    /**
     * Runtime: 11 ms, faster than 89.24% of Java online submissions for Power of Three.
     *
     * Memory Usage: 36.4 MB, less than 6.25% of Java online submissions for Power of Three.
     *
     * Copy from: https://leetcode.com/problems/power-of-three/solution/[Power of Three solution - LeetCode]
     */
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
    /**
     * Runtime: 11 ms, faster than 89.24% of Java online submissions for Power of Three.
     *
     * Memory Usage: 36.6 MB, less than 6.25% of Java online submissions for Power of Three.
     *
     * Copy from: https://leetcode.com/problems/power-of-three/solution/[Power of Three solution - LeetCode]
     */
    public boolean isPowerOfThreeDiv(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    /**
     * Time Limit Exceeded
     */
    public boolean isPowerOfThreeMult(int n) {
        if (n < 1) {
            return false;
        }
        int temp = 1;
        for (int i = 0; temp <= n && i < n; i++) {
            if (temp == n) {
                return true;
            }
            temp *= 3;
        }
        return false;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0326_PowerOfThree solution = new _0326_PowerOfThree();
        System.out.println(solution.isPowerOfThree(2147483647));
        System.out.println(solution.isPowerOfThree(45));
        System.out.println(solution.isPowerOfThree(81));
    }
}
