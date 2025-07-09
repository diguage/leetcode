package com.diguage.algo.leetcode;


public class _0304_RangeSumQuery2DImmutable {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-04 17:09:17
   */
  static class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
      sums = new int[matrix.length + 1][matrix[0].length + 1];
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
          if (i == 0) {
            sums[i + 1][j + 1] = sums[i + 1][j] + matrix[i][j];
          } else if (j == 0) {
            sums[i + 1][j + 1] = sums[i][j + 1] + matrix[i][j];
          } else {
            sums[i + 1][j + 1] = sums[i + 1][j]
              + sums[i][j + 1] + matrix[i][j] - sums[i][j];
          }
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1]
        - sums[row1][col2 + 1] + sums[row1][col1];
    }
  }

  // end::answer[]


  public static void main(String[] args) {
    NumMatrix m = new NumMatrix(new int[][]{
      {3, 0, 1, 4, 2},
      {5, 6, 3, 2, 1},
      {1, 2, 0, 1, 5},
      {4, 1, 0, 1, 7},
      {1, 0, 3, 0, 5}});
    int result = m.sumRegion(2, 1, 4, 3);
    System.out.println(result);
  }
}
