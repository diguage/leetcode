package com.diguage.algo.leetcode;

public class _0048_RotateImage_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 17:35:53
   */
  public void rotate(int[][] matrix) {
    backtrack(matrix, 0, 0,
      matrix.length, matrix.length);
  }

  private void backtrack(int[][] matrix,
                         int row, int column,
                         int rLen, int cLen) {
    if (rLen <= 1) {
      return;
    }
    // 旋转
    for (int i = 0; i < cLen - 1; i++) {
      int tmp = matrix[row][column + i];
      matrix[row][column + i] = matrix[row + rLen - 1 - i][column];
      matrix[row + rLen - 1 - i][column] = matrix[row + rLen - 1][column + cLen - 1 - i];
      matrix[row + rLen - 1][column + cLen - 1 - i] = matrix[row + i][column + cLen - 1];
      matrix[row + i][column + cLen - 1] = tmp;
    }
    backtrack(matrix, row + 1, column + 1, rLen - 2, cLen - 2);
  }
  // end::answer[]
}
