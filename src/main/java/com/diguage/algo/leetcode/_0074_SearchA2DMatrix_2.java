package com.diguage.algo.leetcode;

public class _0074_SearchA2DMatrix_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-18 22:23:27
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int low = 0, high = m * n - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int row = mid / n;
      int col = mid % n;
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return false;
  }
  // end::answer[]
}
