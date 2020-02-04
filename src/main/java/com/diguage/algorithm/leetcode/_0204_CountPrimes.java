package com.diguage.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * = 204. Count Primes
 *
 * https://leetcode.com/problems/count-primes/[Count Primes - LeetCode]
 *
 * ount the number of prime numbers less than a non-negative number, **n**.
 *
 * .Example:
 * [source]
 * ----
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-10 23:04
 */
public class _0204_CountPrimes {
    /**
     * Runtime: 163 ms, faster than 25.96% of Java online submissions for Count Primes.
     *
     * Memory Usage: 93.7 MB, less than 5.66% of Java online submissions for Count Primes.
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        Set<Integer> numbers = new HashSet<>();
        numbers.add(2);
        for (int i = 3; i < n; ) {
            numbers.add(i);
            i += 2;
        }
        for (int i = 3; i < Math.sqrt(n); ) {
            for (int j = 3; i * j < n; ) {
                numbers.remove(i * j);
                j += 2;
            }
            i += 2;
        }
        return numbers.size();
    }

    public static void main(String[] args) {
        _0204_CountPrimes solution = new _0204_CountPrimes();
        int r1 = solution.countPrimes(100);
        System.out.println((r1 == 4) + " : " + r1);
    }
}
