package com.diguage.algorithm.leetcode;

import static com.diguage.algorithm.util.PrintUtils.printMatrix;

/**
 * = 59. Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/[Spiral Matrix II - LeetCode]
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * .Example:
 * [source]
 * ----
 * Input: 3
 * Output:
 * [
 *   [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-26 00:54
 */
public class _0059_SpiralMatrixIi {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
     *
     * Memory Usage: 34.3 MB, less than 8.33% of Java online submissions for Spiral Matrix II.
     */
    public int[][] generateMatrix(int n) {
        int x1 = 0, x2 = n - 1;
        int y1 = 0, y2 = n - 1;
        int i = 1;
        int[][] matrix = new int[n][n];
        while (x1 <= x2 && y1 <= y2) {
            for (int x = x1; x <= x2; x++) {
                matrix[y1][x] = i++;
            }
            for (int y = y1 + 1; y <= y2; y++) {
                matrix[y][x2] = i++;
            }
            if (x1 < x2 && y1 < y2) {
                for (int x = x2 - 1; x > x1; x--) {
                    matrix[y2][x] = i++;
                }
                for (int y = y2; y > y1; y--) {
                    matrix[y][x1] = i++;
                }
            }
            x1++;
            x2--;
            y1++;
            y2--;
        }

        return matrix;
    }

    public static void main(String[] args) {
        _0059_SpiralMatrixIi solution = new _0059_SpiralMatrixIi();
        int[][] r1 = solution.generateMatrix(5);
        printMatrix(r1);
    }
}
