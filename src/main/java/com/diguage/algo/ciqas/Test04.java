package com.diguage.algo.ciqas;

import java.util.Objects;

/**
 * {@link com.diguage.algo.leetcode._0240_SearchA2DMatrixII}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 19:49
 */
public class Test04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (Objects.isNull(matrix) || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int y = 0;
        int x = matrix[0].length - 1;
        while (0 <= x && y < matrix.length) {
            int num = matrix[y][x];
            if (num < target) {
                y++;
            } else if (target < num) {
                x--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Test04 solutiong = new Test04();
        System.out.println(solutiong.findNumberIn2DArray(matrix, 5));

        int[][] matrix2 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solutiong.findNumberIn2DArray(matrix2, 20));

    }
}
