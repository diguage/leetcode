package com.diguage.algo.leetcode;

public class _0240_SearchA2DMatrixIi_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-25 21:18:23
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int r = 0, c = matrix[0].length - 1;
    while (r < matrix.length && 0 <= c) {
      int num = matrix[r][c];
      if (num == target) {
        return true;
      } else if (num < target) {
        r++;
      } else if (num > target) {
        c--;
      }
    }
    return false;
  }
  // end::answer[]
}
