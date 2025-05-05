package com.diguage.algo.leetcode;

public class _2684_MaximumNumberOfMovesInAGrid_1 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-05 22:38:45
   */
  public int maxMoves(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    int result = 0;
    // 📢：注意这里的遍历顺序，需要按列向右推进
    for (int column = 1; column < n; column++) {
      // 不加 stop，击败 12.96%；加 stop，击败 50.07%
      boolean stop = true;
      for (int row = 0; row < m; row++) {
        if (row - 1 >= 0 && grid[row - 1][column - 1] < grid[row][column]
          && (column == 1 || dp[row - 1][column - 1] > 0)) {
          dp[row][column] = Math.max(dp[row][column], dp[row - 1][column - 1] + 1);
          stop = false;
        }
        if (grid[row][column - 1] < grid[row][column]
          && (column == 1 || dp[row][column - 1] > 0)) {
          dp[row][column] = Math.max(dp[row][column], dp[row][column - 1] + 1);
          stop = false;
        }
        if (row + 1 < m && grid[row + 1][column - 1] < grid[row][column]
          && (column == 1 || dp[row + 1][column - 1] > 0)) {
          dp[row][column] = Math.max(dp[row][column], dp[row + 1][column - 1] + 1);
          stop = false;
        }
        result = Math.max(result, dp[row][column]);
      }
      if (stop) {
        return result;
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _2684_MaximumNumberOfMovesInAGrid_1().maxMoves(new int[][]{
      {65, 200, 263, 220, 91, 183, 2, 187, 175, 61, 225, 120, 39},
      {111, 242, 294, 31, 241, 90, 145, 25, 262, 214, 145, 71, 294},
      {152, 25, 240, 69, 279, 238, 222, 9, 137, 277, 8, 143, 143},
      {189, 31, 86, 250, 20, 63, 188, 209, 75, 22, 127, 272, 110},
      {122, 94, 298, 25, 90, 169, 68, 3, 208, 274, 202, 135, 275},
      {205, 20, 171, 90, 70, 272, 280, 138, 142, 151, 80, 122, 130},
      {284, 272, 271, 269, 265, 134, 185, 243, 247, 50, 283, 20, 232},
      {266, 236, 265, 234, 249, 62, 98, 130, 122, 226, 285, 168, 204},
      {231, 24, 256, 101, 142, 28, 268, 82, 111, 63, 115, 13, 144},
      {277, 277, 31, 144, 49, 132, 28, 138, 133, 29, 286, 45, 93},
      {163, 96, 25, 9, 3, 159, 148, 59, 25, 81, 233, 127, 12},
      {127, 38, 31, 209, 300, 256, 15, 43, 74, 64, 73, 141, 200}
    });
  }
}
