package com.diguage.algo.leetcode;

public class _0240_SearchA2DMatrixIi_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-20 20:26:28
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = 0, column = matrix[row].length - 1;
    while (row < matrix.length && column >= 0) {
      int num = matrix[row][column];
      if (num == target) {
        return true;
      } else if (target < num) {
        column--;
      } else {
        row++;
      }
    }
    return false;
  }

  // end::answer[]
  static void main() {
    int[][] matrix = {
      {1, 4, 7, 11, 15},
      {2, 5, 8, 12, 19},
      {3, 6, 9, 16, 22},
      {10, 13, 14, 17, 24},
      {18, 21, 23, 26, 30}
    };
    new _0240_SearchA2DMatrixIi_3().searchMatrix(matrix, 20);
  }
}
