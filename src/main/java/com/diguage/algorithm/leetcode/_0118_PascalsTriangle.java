package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * = 118. Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/[Pascal's Triangle - LeetCode]
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * .Example:
 * [source]
 * ----
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-25 01:04
 */
public class _0118_PascalsTriangle {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
     *
     * Memory Usage: 34 MB, less than 7.23% of Java online submissions for Pascal's Triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> parent = result.get(i - 1);
            int length = parent.size() + 1;
            List<Integer> current = new ArrayList<>(length);
            current.add(1);
            for (int j = 1; j < length; j++) {
                int left = parent.get(j - 1);
                int right = j >= parent.size() ? 0 : parent.get(j);
                current.add(left + right);
            }
            result.add(current);
        }

        return result;
    }

    public static void main(String[] args) {
        _0118_PascalsTriangle solution = new _0118_PascalsTriangle();
        List<List<Integer>> r1 = solution.generate(5);
        System.out.println(Arrays.deepToString(r1.toArray()));
    }
}
