package com.diguage.algorithm.leetcode;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * = 120. Triangle
 *
 * https://leetcode.com/problems/triangle/[Triangle - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-07 23:14
 */
public class _0120_Triangle {
    /**
     * Runtime: 1 ms, faster than 99.42% of Java online submissions for Triangle.
     * Memory Usage: 39.2 MB, less than 8.16% of Java online submissions for Triangle.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] sums = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                sums[j] = Math.min(sums[j], sums[j + 1]) + row.get(j);
            }
        }
        return sums[0];
    }

    public static void main(String[] args) {
        _0120_Triangle solution = new _0120_Triangle();
        List<List<Integer>> t1 = asList(asList(2), asList(3, 4), asList(6, 5, 7), asList(4, 1, 8, 3));
        int r1 = solution.minimumTotal(t1);
        System.out.println((r1 == 11) + " : " + r1);
    }
}
