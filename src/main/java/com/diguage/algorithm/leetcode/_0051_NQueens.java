package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 51. N-Queens
 *
 * [N-Queens - LeetCode](https://leetcode.com/problems/n-queens/)
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-05 12:55
 */
public class _0051_NQueens {
    /**
     * Runtime: 4 ms, faster than 64.59% of Java online submissions for N-Queens.
     * Memory Usage: 41.3 MB, less than 5.41% of Java online submissions for N-Queens.
     */
    public List<List<String>> solveNQueens(int n) {
        int[][] matrix = new int[n][n];
        List<List<String>> result = new ArrayList<>();
        backtrack(matrix, 0, 0, result);
        int size = result.size();
        if (size == 0) {
            return result;
        }
        for (int i = 0; i < size; i++) {
            List<String> om = result.get(i);
            // 如果长度是奇数，而且第一行中间是合法位置，则在回溯过程中已经产生了对称解法。
            if (!(n % 2 == 1 && om.get(0).charAt(getMid(n)) == 'Q')) {
                List<String> nm = reverseMatrix(om);
                result.add(nm);
            }
        }
        return result;
    }

    private List<String> reverseMatrix(List<String> matrix) {
        List<String> result = new ArrayList<>(matrix.size());
        for (String s : matrix) {
            StringBuilder sb = new StringBuilder(s);
            result.add(sb.reverse().toString());
        }
        return result;
    }

    private void backtrack(int[][] matrix, int y, int step, List<List<String>> result) {
        int length = matrix.length;
        if (step == length) {
            result.add(matrixToList(matrix));
            return;
        }
        for (int xi = 0; xi < length; xi++) {
            if (y == 0) {
                int mid = getMid(length);
                if (mid < xi) {
                    break;
                }
            }
            if (isValid(matrix, y, xi)) {
                matrix[y][xi] = 1;
                backtrack(matrix, y + 1, step + 1, result);
                matrix[y][xi] = 0;
            }
        }
    }

    private int getMid(int length) {
        return length % 2 == 0 ? length / 2 - 1 : length / 2;
    }

    private List<String> matrixToList(int[][] matrix) {
        List<String> result = new ArrayList<>(matrix.length);
        for (int y = 0; y < matrix.length; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 0) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private boolean isValid(int[][] matrix, int y, int x) {
        int len = matrix.length;
        // 同列
        for (int i = 0; i < y; i++) {
            if (matrix[i][x] == 1) {
                return false;
            }
        }
//        // 同行
//        for (int i = 0; i < len; i++) {
//            if (i != x && matrix[y][i] == 1) {
//                return false;
//            }
//        }
        // 左上角
        for (int i = 1; i < len && y - i >= 0 && x - i >= 0; i++) {
            if (matrix[y - i][x - i] == 1) {
                return false;
            }
        }
        // 右上角：从右上角到最下角的对角线，他们 "行号 + 列号 = 常数"
        int sum = x + y;
        for (int yi = y - 1; yi >= 0 && 0 <= sum - yi && sum - yi < len; yi--) {
            if (matrix[yi][sum - yi] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _0051_NQueens solution = new _0051_NQueens();

        List<List<String>> r1 = solution.solveNQueens(14);
        printMatrix(r1);
    }

    public static <T> void printMatrix(List<List<T>> matrix) {
        for (List<T> list : matrix) {
            for (T t : list) {
                System.out.println(t);
            }
            System.out.println("--------------------");
        }
    }
}
