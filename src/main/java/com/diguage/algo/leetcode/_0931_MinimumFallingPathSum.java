package com.diguage.algo.leetcode;

public class _0931_MinimumFallingPathSum {
  // tag::answer[]

  /**
   * 动态规划，没有优化
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-03 14:26:47
   */
  public int minFallingPathSum(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    System.arraycopy(matrix[0], 0, dp[0], 0, matrix[0].length);
    for (int row = 1; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {
        int num = dp[row - 1][column];
        if (0 <= column - 1) {
          num = Math.min(num, dp[row - 1][column - 1]);
        }
        if (column + 1 < matrix[row].length) {
          num = Math.min(num, dp[row - 1][column + 1]);
        }
        dp[row][column] = matrix[row][column] + num;
      }
    }
    int result = Integer.MAX_VALUE;
    for (int column = 0; column < dp[dp.length - 1].length; column++) {
      result = Math.min(result, dp[dp.length - 1][column]);
    }
    return result;
  }
  // end::answer[]
}
