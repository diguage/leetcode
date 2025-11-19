package com.diguage.algo.leetcode;

public class _0073_SetMatrixZeroes_22 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-19 22:32
   */
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    // 第一列有没有 0
    boolean rowHasZero = false;
    for (int c = 0; c < m; c++) {
      if (matrix[c][0] == 0) {
        rowHasZero = true;
        break;
      }
    }
    // 第一行有没有 0
    boolean colHasZero = false;
    for (int r = 0; r < n; r++) {
      if (matrix[0][r] == 0) {
        colHasZero = true;
      }
    }

    // 将出现的 0 首行和首列标记一下
    for (int c = 1; c < m; c++) {
      for (int r = 1; r < n; r++) {
        if (matrix[c][r] == 0) {
          matrix[c][0] = 0;
          matrix[0][r] = 0;
        }
      }
    }
    // 根据首行和首列来修改为 0
    for (int c = 1; c < m; c++) {
      if (matrix[c][0] == 0) {
        for (int r = 1; r < n; r++) {
          matrix[c][r] = 0;
        }
      }
    }
    for (int r = 1; r < n; r++) {
      if (matrix[0][r] == 0) {
        for (int c = 1; c < m; c++) {
          matrix[c][r] = 0;
        }
      }
    }
    // 最后处理首行和首列
    if (colHasZero) {
      for (int r = 0; r < n; r++) {
        matrix[0][r] = 0;
      }
    }
    if (rowHasZero) {
      for (int c = 0; c < m; c++) {
        matrix[c][0] = 0;
      }
    }
  }
  // end::answer[]

  static void main() {
    int[][] matrix5 = {{1, 0}};
//    int[][] matrix5 = {
//      {1, 1, 1},
//      {1, 0, 1},
//      {32, 1, 1}};
//    int[][] matrix5 = {
//      {0, 1, 2, 0},
//      {3, 4, 5, 2},
//      {1, 3, 1, 5}};
//    int[][] matrix5 = {
//      {8, 3, 6, 9, 7, 8, 0, 6},
//      {0, 3, 7, 0, 0, 4, 3, 8},
//      {5, 3, 6, 7, 1, 6, 2, 6},
//      {8, 7, 2, 5, 0, 6, 4, 0},
//      {0, 2, 9, 9, 3, 9, 7, 3}};
    new _0073_SetMatrixZeroes_22()
      .setZeroes(matrix5);
  }
}
