package com.diguage.algo.leetcode;

public class _0566_ReshapeTheMatrix {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-19 20:21:06
   */
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    int m = mat.length;
    int n = mat[0].length;
    if (m * n != r * c) {
      return mat;
    }
    int[][] result = new int[r][c];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int num = i * n + j;
        result[num / c][num % c] = mat[i][j];
      }
    }
    return result;
  }
  // end::answer[]
}
