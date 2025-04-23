package com.diguage.algo.leetcode;

public class _0074_SearchA2DMatrix {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-23 18:20:50
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    int column = matrix[0].length;
    int left = 0, right = row * column - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int num = matrix[mid / column][mid % column];
      if (num == target) {
        return true;
      } else if (target < num) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0074_SearchA2DMatrix().searchMatrix(new int[][]{
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}},
      3);
  }
}
