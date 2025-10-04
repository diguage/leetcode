package com.diguage.algo.leetcode;

public class _2684_MaximumNumberOfMovesInAGrid_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-04 23:09:00
   */
  public int maxMoves(int[][] grid) {
    int row = grid.length;
    int column = grid[0].length;
    int[][] dp = new int[row][column];
    int result = 0;
    // 📢注意：是从左向右移动，不是从上向下移动！！！
    for (int c = 1; c < column; c++) {
      for (int r = 0; r < row; r++) {
        int h1 = r == 0 ? Integer.MAX_VALUE : grid[r - 1][c - 1];
        int h2 = grid[r][c - 1];
        int h3 = r == row - 1 ? Integer.MAX_VALUE : grid[r + 1][c - 1];
        int num = grid[r][c];
        if (h1 < num && (c == 1 || dp[r - 1][c - 1] > 0)) {
          dp[r][c] = Math.max(dp[r][c], dp[r - 1][c - 1] + 1);
        }
        if (h2 < num && (c == 1 || dp[r][c - 1] > 0)) {
          dp[r][c] = Math.max(dp[r][c], dp[r][c - 1] + 1);
        }
        if (h3 < num && (c == 1 || dp[r + 1][c - 1] > 0)) {
          dp[r][c] = Math.max(dp[r][c], dp[r + 1][c - 1] + 1);
        }
        result = Math.max(result, dp[r][c]);
        if (result == column) {
          break;
        }
      }
      // 如果不能移动则直接退出！
      if (result == 0 || result == column) {
        break;
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _2684_MaximumNumberOfMovesInAGrid_2()
      .maxMoves(new int[][]{
        {3, 2, 4},
        {2, 1, 9},
        {1, 1, 7}});

  }
}
