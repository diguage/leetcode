package com.diguage.algo.leetcode;

public class _0766_ToeplitzMatrix {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-09 22:17:27
   */
  public boolean isToeplitzMatrix(int[][] matrix) {
    int row = matrix.length;
    int column = matrix[0].length;
    // 找出从 [0, 0] 开始的对角线
    int max = Math.max(row, column);
    int[][] diagonal = new int[max][2];
    for (int i = 0; i < max; i++) {
      diagonal[i] = new int[]{i, i};
    }
    // 向右平移
    for (int c = 0; c < column; c++) {
      int num = matrix[diagonal[0][0]][diagonal[0][1] + c];
      for (int i = 1; i < diagonal.length && diagonal[i][0] < row
        && diagonal[i][1] + c < column; i++) {
        if (num != matrix[diagonal[i][0]][diagonal[i][1] + c]) {
          return false;
        }
      }
    }
    // 向下平移
    for (int r = 1; r < row; r++) {
      int num = matrix[diagonal[0][0] + r][diagonal[0][1]];
      for (int i = 1; i < diagonal.length && diagonal[i][0] + r < row
        && diagonal[i][1] < column; i++) {
        if (num != matrix[diagonal[i][0] + r][diagonal[i][1]]) {
          return false;
        }
      }
    }
    return true;
  }
  // end::answer[]
}
