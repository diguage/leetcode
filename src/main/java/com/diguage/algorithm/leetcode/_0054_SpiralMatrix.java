package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 54. Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/[Spiral Matrix - LeetCode]
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * .Example 1:
 * [source]
 * ----
 * Input:
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-26 00:51:20
 */
public class _0054_SpiralMatrix {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     *
     * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Spiral Matrix.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0) {
            return Collections.emptyList();
        }
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        List<Integer> result = new ArrayList<>(xLength * yLength);
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                result.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                result.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    result.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    result.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }

    public static void main(String[] args) {
        _0054_SpiralMatrix solution = new _0054_SpiralMatrix();

        int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> r1 = solution.spiralOrder(array1);
        System.out.println(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5).equals(r1)
                + " : " + Arrays.toString(r1.toArray()));

        int[][] array2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> r2 = solution.spiralOrder(array2);
        System.out.println(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7).equals(r2)
                + " : " + Arrays.toString(r2.toArray()));
    }
}

