package com.diguage.algorithm.leetcode;

/**
 * = 52. N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/[N-Queens II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-05 16:25
 */
public class _0052_NQueensII {
  // tag::answer[]
    /**
     * Runtime: 1 ms, faster than 95.68% of Java online submissions for N-Queens II.
     * Memory Usage: 36 MB, less than 8.70% of Java online submissions for N-Queens II.
     */
    private int result = 0;
    public int totalNQueens(int n) {
        int[][] matrix = new int[n][n];
        backtrack(matrix, 0, 0);
        return result;
    }

    private void backtrack(int[][] matrix, int y, int step) {
        if (step == matrix.length) {
            result++;
            return;
        }
        for (int xi = 0; xi < matrix[0].length; xi++) {
            if (isValid(matrix, y, xi)) {
                matrix[y][xi] = 1;
                backtrack(matrix, y + 1, step + 1);
                matrix[y][xi] = 0;
            }
        }
    }

    private boolean isValid(int[][] matrix, int y, int x) {
        int len = matrix.length;
        // 同列
        for (int i = 0; i < y; i++) {
            if (matrix[i][x] == 1) {
                return false;
            }
        }
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

  // end::answer[]


    public static void main(String[] args) {
        _0052_NQueensII solution = new _0052_NQueensII();
        int r1 = solution.totalNQueens(4);
        System.out.println((r1 == 2) + " : " + r1);
    }
}
