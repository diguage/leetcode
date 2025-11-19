package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0073_SetMatrixZeroes_20 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-19 20:32
   */
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    // 记录 行号和列号，最后按照行号和列号来进行处理
    Set<String> zeros = new HashSet<>();
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (matrix[r][c] == 0) {
          zeros.add("r" + r);
          zeros.add("c" + c);
        }
      }
    }
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (zeros.contains("r" + r) || zeros.contains("c" + c)) {
          matrix[r][c] = 0;
        }
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
    new _0073_SetMatrixZeroes_20()
      .setZeroes(matrix5);
  }
}
