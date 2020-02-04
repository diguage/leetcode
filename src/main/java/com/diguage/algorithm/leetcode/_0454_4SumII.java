package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * = 454. 4Sum II
 *
 * https://leetcode.com/problems/4sum-ii/[4Sum II - LeetCode]
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples `(i, j, k, l)` there are such that `A[i] + B[j] + C[k] + D[l]` is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -2^28^ to 2^28^ - 1 and the result is guaranteed to be at most 2^31^ - 1.
 *
 * .Example:
 * [source]
 * ----
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-11 13:02
 */
public class _0454_4SumII {
    /**
     * Runtime: 94 ms, faster than 38.81% of Java online submissions for 4Sum II.
     *
     * Memory Usage: 58.6 MB, less than 64.00% of Java online submissions for 4Sum II.
     *
     * https://leetcode.com/problems/4sum-ii/discuss/93920/Clean-java-solution-O(n2)[Clean java solution O(n^2) - LeetCode Discuss]
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int value = A[i] + B[j];
                Integer count = numToCountMap.getOrDefault(value, 0);
                numToCountMap.put(value, ++count);
            }
        }
        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                result += numToCountMap.getOrDefault(0 - C[i] - D[j], 0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _0454_4SumII solution = new _0454_4SumII();
        int r1 = solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println((r1 == 2) + " : " + r1);
    }
}
