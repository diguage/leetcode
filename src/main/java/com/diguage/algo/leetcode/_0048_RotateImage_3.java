package com.diguage.algo.leetcode;

public class _0048_RotateImage_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-25 17:00:44
   */
  public void rotate(int[][] matrix) {
    dfs(matrix, 0, 0,
      matrix.length - 1, matrix[matrix.length - 1].length - 1);
  }

  private void dfs(int[][] matrix,
                   int startRow, int startColumn,
                   int endRow, int endColumn) {
    if (startRow >= endRow || startColumn >= endColumn) {
      return;
    }
    int length = endRow - startRow;
    for (int i = 0; i < length; i++) {
      // 左上角： matrix[startRow][startColumn + i] // 向右 column 增加
      // 右上角： matrix[startRow + i][endColumn]   // 向下 row 增加
      // 右下角： matrix[endRow][endColumn - i]     // 向左 column 减少
      // 左下角： matrix[endRow - i][startColumn]   // 向上 row 减少
      int temp = matrix[startRow][startColumn + i];
      matrix[startRow][startColumn + i] = matrix[endRow - i][startColumn];
      matrix[endRow - i][startColumn] = matrix[endRow][endColumn - i];
      matrix[endRow][endColumn - i] = matrix[startRow + i][endColumn];
      matrix[startRow + i][endColumn] = temp;
    }
    dfs(matrix, startRow + 1, startColumn + 1,
      endRow - 1, endColumn - 1);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0048_RotateImage_3().rotate(new int[][]{
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}});
  }
}
