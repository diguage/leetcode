package com.diguage.algo.leetcode;

public class _0048_RotateImage_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-11 23:17:50
   */
  public void rotate(int[][] matrix) {
    dfs(matrix, 0, 0, matrix.length - 1, matrix.length - 1);
  }

  private void dfs(int[][] matrix,
                   int rowStart, int columnStart,
                   int rowEnd, int columnEnd) {
    if (rowStart >= rowEnd && columnStart >= columnEnd) {
      return;
    }
    for (int i = 0; i < rowEnd - rowStart; i++) {
      int temp = matrix[rowStart + i][columnStart];
      matrix[rowStart + i][columnStart] = matrix[rowEnd][columnStart + i];
      matrix[rowEnd][columnStart + i] = matrix[rowEnd - i][columnEnd];
      matrix[rowEnd - i][columnEnd] = matrix[rowStart][columnEnd - i];
      matrix[rowStart][columnEnd - i] = temp;
    }
    dfs(matrix, rowStart + 1, columnStart + 1, rowEnd - 1, columnEnd - 1);
  }
  // end::answer[]
  static void main() {
    new _0048_RotateImage_4().rotate(new int[][]{
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}});
  }
}
