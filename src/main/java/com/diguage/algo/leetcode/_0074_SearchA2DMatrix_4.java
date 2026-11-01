package com.diguage.algo.leetcode;

public class _0074_SearchA2DMatrix_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-01 21:57:09
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int length = matrix[0].length;
    int min = 0, max = matrix.length * length - 1;
    while (min <= max) {
      int mid = min + (max - min) / 2;
      int row = mid / length;
      int column = mid % length;
      int num = matrix[row][column];
      if (num == target) {
        return true;
      } else if (num < target) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    return false;
  }
  // end::answer[]
}
