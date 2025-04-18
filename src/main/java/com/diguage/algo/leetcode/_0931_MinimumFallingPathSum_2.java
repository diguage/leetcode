package com.diguage.algo.leetcode;

public class _0931_MinimumFallingPathSum_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-18 22:56:51
   */
  public int minFallingPathSum(int[][] matrix) {
    int len = matrix.length;
    if (len == 1) {
      return matrix[0][0];
    }
    int result = Integer.MAX_VALUE;
    for (int r = 1; r < len; r++) {
      for (int c = 0; c < len; c++) {
        int min;
        if (c == 0) {
          min = Math.min(matrix[r - 1][c], matrix[r - 1][c + 1]);
        } else if (c == len - 1) {
          min = Math.min(matrix[r - 1][c - 1], matrix[r - 1][c]);
        } else {
          min = Math.min(matrix[r - 1][c], Math.min(matrix[r - 1][c - 1], matrix[r - 1][c + 1]));
        }
        matrix[r][c] = matrix[r][c] + min;
        if (r == len - 1) {
          result = Math.min(result, matrix[r][c]);
        }
      }
    }
    return result;
  }
  // end::answer[]
}
