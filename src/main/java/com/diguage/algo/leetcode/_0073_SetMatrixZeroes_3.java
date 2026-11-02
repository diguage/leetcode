package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0073_SetMatrixZeroes_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-02 19:07:33
   */
  public void setZeroes(int[][] matrix) {
    boolean firstZero = matrix[0][0] == 0;
    boolean firstRowZero = firstZero;
    boolean firstColZero = firstZero;

    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[r].length; c++) {
        if (matrix[0][c] == 0) {
          firstRowZero = true;
        }
        if (matrix[r][0] == 0) {
          firstColZero = true;
        }
      }
    }
    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[r].length; c++) {
        if (matrix[r][c] == 0) {
          matrix[0][c] = 0;
          matrix[r][0] = 0;
        }
      }
    }
    for (int r = 1; r < matrix.length; r++) {
      for (int c = 1; c < matrix[r].length; c++) {
        if (matrix[0][c] == 0 || matrix[r][0] == 0) {
          matrix[r][c] = 0;
        }
      }
    }
    if (firstRowZero) {
      for (int c = 0; c < matrix[0].length; c++) {
        matrix[0][c] = 0;
      }
    }
    if (firstColZero) {
      for (int r = 0; r < matrix.length; r++) {
        matrix[r][0] = 0;
      }
    }
  }

  // end::answer[]
  static void main() {
        int[][] matrix5 = {
          {1, 1, 1},
          {1, 0, 1},
          {32, 1, 1}};
//    int[][] matrix5 = {
//      {0, 1, 2, 0},
//      {3, 4, 5, 2},
//      {1, 3, 1, 5}};
    new _0073_SetMatrixZeroes_3().setZeroes(matrix5);
  }
}
