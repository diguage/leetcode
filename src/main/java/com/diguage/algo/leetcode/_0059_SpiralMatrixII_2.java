package com.diguage.algo.leetcode;

public class _0059_SpiralMatrixII_2 {
// tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 16:02:29
   */
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    backtrack(matrix, 1, 0, 0, n, n);
    return matrix;
  }

  private void backtrack(int[][] matrix, int start,
                         int row, int column,
                         int rLen, int cLen) {
    int n = matrix.length;
    if (n * n < start) {
      return;
    }
    for (int i = column; i < column + cLen; i++) {
      matrix[row][i] = start++;
    }
    for (int i = row + 1; i < row + rLen; i++) {
      matrix[i][column + cLen - 1] = start++;
    }
    // 不想增加复杂判断了，数量足够就直接返回
    // 如果不返回，在最后只剩下一层且有多个元素时，中间元素会被重复添加
    if (n * n < start) {
      return;
    }
    for (int i = column + cLen - 2; i >= column; i--) {
      matrix[row + rLen - 1][i] = start++;
    }
    for (int i = row + rLen - 2; i > row; i--) {
      matrix[i][column] = start++;
    }
    backtrack(matrix, start, row + 1, column + 1, rLen - 2, cLen - 2);
  }
  // end::answer[]
}
