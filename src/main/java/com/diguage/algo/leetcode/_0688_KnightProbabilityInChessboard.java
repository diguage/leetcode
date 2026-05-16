package com.diguage.algo.leetcode;

public class _0688_KnightProbabilityInChessboard {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-16 23:24:19
   */
  private static final int[][] DIRS = {{2, 1}, {1, 2},
    {-1, 2}, {-2, 1,}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

  public double knightProbability(int n, int k, int row, int column) {
    double[][][] memo = new double[k + 1][n][n];
    return dfs(n, k, row, column, memo);
  }

  private double dfs(int n, int k, int row, int column, double[][][] memo) {
    if (row < 0 || row >= n || column < 0 || column >= n) {
      return 0;
    }
    if (k == 0) {
      return 1;
    }
    if (memo[k][row][column] > 0) {
      return memo[k][row][column];
    }
    double result = 0;
    for (int[] d : DIRS) {
      result += dfs(n, k - 1, row + d[0], column + d[1], memo);
    }
    return memo[k][row][column] = result / DIRS.length;
  }
  // end::answer[]

}
