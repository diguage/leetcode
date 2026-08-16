package com.diguage.algo.leetcode;

public class _0867_TransposeMatrix {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-16 22:37:35
   */
  public int[][] transpose(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] result = new int[n][m];
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        result[c][r] = matrix[r][c];
      }
    }
    return result;
  }
  // end::answer[]

}
