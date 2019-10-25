package com.diguage.algorithm.leetcode;

import java.util.Objects;

import static com.diguage.algorithm.util.PrintUtils.printMatrix;

/**
 * = 48. Rotate Image
 *
 * https://leetcode.com/problems/rotate-image/[Rotate Image - LeetCode]
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * *Note:*
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * .Example 1:
 * [source]
 * ----
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-24 00:57:55
 */
public class RotateImage {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
     *
     * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Rotate Image.
     */
    public void rotate(int[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0) {
            return;
        }
        int length = matrix.length;
        // 先交换行，这样操作更方便，但是也会有更多的额外空间。
        for (int i = 0; i < length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[length - 1 - i];
            matrix[length - 1 - i] = temp;
        }
//        printMatrix(matrix);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
     *
     * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Rotate Image.
     */
    public void rotate1(int[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0) {
            return;
        }
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        printMatrix(matrix);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage solution = new RotateImage();
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(array1);
        solution.rotate(array1);
        printMatrix(array1);

        int[][] array2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        printMatrix(array2);
        solution.rotate(array2);
        printMatrix(array2);
    }
}
