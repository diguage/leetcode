package com.diguage.algo.leetcode;

public class _0240_SearchA2DMatrixII_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 18:14:17
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = 0, column = matrix[0].length - 1;
    while (row < matrix.length && 0 <= column) {
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
}
