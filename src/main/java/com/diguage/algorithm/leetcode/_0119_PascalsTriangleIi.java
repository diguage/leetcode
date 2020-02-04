package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * = 119. Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/[Pascal's Triangle II - LeetCode]
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * .Example:
 * [source]
 * ----
 * Input: 3
 * Output: [1,3,3,1]
 * ----
 *
 * *Follow up:*
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-26 01:34
 */
public class _0119_PascalsTriangleIi {
    /**
     * Runtime: 1 ms, faster than 89.02% of Java online submissions for Pascal's Triangle II.
     *
     * Memory Usage: 33.7 MB, less than 6.17% of Java online submissions for Pascal's Triangle II.
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex * 3 / 2 + 1);
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int left = 1;
            for (int j = 1; j < i + 1; j++) {
                int right = j == result.size() ? 0 : result.get(j);
                int element = left + right;
                if (j == result.size()) {
                    result.add(element);
                } else {
                    result.set(j, element);
                }
                left = right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _0119_PascalsTriangleIi solution = new _0119_PascalsTriangleIi();
        List<Integer> r1 = solution.getRow(3);
        System.out.println(Arrays.asList(1, 3, 3, 1).equals(r1) + " : " + Arrays.toString(r1.toArray()));
    }
}

