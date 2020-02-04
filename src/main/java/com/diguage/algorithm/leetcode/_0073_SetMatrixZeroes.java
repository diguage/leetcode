package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.algorithm.util.PrintUtils.printMatrix;

/**
 * = 73. Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/[Set Matrix Zeroes - LeetCode]
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * .Example 1:
 * [source]
 * ----
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * ----
 *
 * *Follow up:*
 *
 * * A straight forward solution using O(mn) space is probably a bad idea.
 * * A simple improvement uses O(m + n) space, but still not the best solution.
 * * Could you devise a constant space solution?
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-27 00:59
 */
public class _0073_SetMatrixZeroes {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Matrix Zeroes.
     *
     * Memory Usage: 50.4 MB, less than 5.71% of Java online submissions for Set Matrix Zeroes.
     */
    public void setZeroes(int[][] matrix) {
        if (Objects.isNull(matrix) || matrix[0].length == 0) {
            return;
        }
        /**
         * 0 all is 0;
         * 1 row is 0;
         * 2 column is 0;
         * 3 is not 0;
         */
        int flag = 3;
        int value = matrix[0][0];
        if (value == 0) {
            flag = 0;
        }
        int column = matrix.length;
        int row = matrix[0].length;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0 && j > 0 && flag != 0) {
                        flag = 1;
                    }
                    if (i > 0 && j == 0 && flag != 0) {
                        if (flag == 1) {
                            flag = 0;
                        } else {
                            flag = 2;
                        }
                    }
                }
            }
        }
//        printMatrix(matrix);
        for (int i = 1; i < column; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 1; j < row; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < column; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flag == 0) {
            Arrays.fill(matrix[0], 0);
            for (int i = 0; i < column; i++) {
                matrix[i][0] = 0;
            }
        } else if (flag == 1) {
            Arrays.fill(matrix[0], 0);
        } else if (flag == 2) {
            for (int i = 0; i < column; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _0073_SetMatrixZeroes solution = new _0073_SetMatrixZeroes();
//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        printMatrix(matrix);
//        solution.setZeroes(matrix);
//        printMatrix(matrix);
//
//        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 0, 1, 5}};
//        printMatrix(matrix2);
//        solution.setZeroes(matrix2);
//        printMatrix(matrix2);
//
//        int[][] matrix3 = {{6, 1, 2, 7}, {0, 4, 5, 2}, {1, 3, 1, 5}};
//        printMatrix(matrix3);
//        solution.setZeroes(matrix3);
//        printMatrix(matrix3);
//
//        int[][] matrix4 = {{6, 1, 0, 7}, {8, 4, 5, 2}, {1, 3, 1, 5}};
//        printMatrix(matrix4);
//        solution.setZeroes(matrix4);
//        printMatrix(matrix4);

        int[][] matrix5 = {
                {8, 3, 6, 9, 7, 8, 0, 6},
                {0, 3, 7, 0, 0, 4, 3, 8},
                {5, 3, 6, 7, 1, 6, 2, 6},
                {8, 7, 2, 5, 0, 6, 4, 0},
                {0, 2, 9, 9, 3, 9, 7, 3}};
        printMatrix(matrix5);
        solution.setZeroes(matrix5);
        printMatrix(matrix5);
    }
}
