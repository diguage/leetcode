package com.diguage.algo.leetcode;

public class _0074_SearchA2DMatrix_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-18 22:23:27
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int r = 0, c = matrix[r].length - 1;
    while (r < matrix.length && 0 <= c) {
      int num = matrix[r][c];
      if (num == target) {
        return true;
      }
      if (target < num) {
        c--;
      } else {
        r++;
      }
    }
    return false;
  }
  // end::answer[]

  static void main() {
    new _0074_SearchA2DMatrix_3()
      .searchMatrix(new int[][]{
          {1, 3, 5, 7},
          {10, 11, 16, 20},
          {23, 30, 34, 60}},
        3);
  }
}
