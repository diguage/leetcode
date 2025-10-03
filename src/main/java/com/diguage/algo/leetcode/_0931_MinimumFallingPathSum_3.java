package com.diguage.algo.leetcode;

import jnr.ffi.annotations.In;

public class _0931_MinimumFallingPathSum_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-03 22:14:49
   */
  public int minFallingPathSum(int[][] matrix) {
    int result = matrix[0][0];
    int row = matrix.length;
    int col = matrix[0].length;
    for (int r = 1; r < row; r++) {
      int temp = Integer.MAX_VALUE;
      for (int c = 0; c < col; c++) {
        matrix[r][c] = matrix[r][c] + Math.min(
          Math.min(c > 0 ? matrix[r - 1][c - 1] : Integer.MAX_VALUE,
            c < col - 1 ? matrix[r - 1][c + 1] : Integer.MAX_VALUE),
          matrix[r - 1][c]);
        temp = Math.min(temp, matrix[r][c]);
      }
      result = temp;
    }
    return result;
  }
  // end::answer[]
}
