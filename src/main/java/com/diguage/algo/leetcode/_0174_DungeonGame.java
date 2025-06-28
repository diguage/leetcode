package com.diguage.algo.leetcode;

public class _0174_DungeonGame {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-28 22:12:35
   */
  public int calculateMinimumHP(int[][] dungeon) {
    int rows = dungeon.length;
    int cols = dungeon[0].length;
    int[][] dp = new int[rows][cols];
    dp[rows - 1][cols - 1] = dungeon[rows - 1][cols - 1];
    // 最后一列
    for (int r = rows - 2; r >= 0; r--) {
      if (dungeon[r][cols - 1] > 0) {
        dp[r][cols - 1] = dp[r + 1][cols - 1] + dungeon[r][cols - 1];
      } else {
        if (dp[r + 1][cols - 1] < 0) {
          dp[r][cols - 1] = dp[r + 1][cols - 1] + dungeon[r][cols - 1];
        } else {
          dp[r][cols - 1] = dungeon[r][cols - 1];
        }
      }
    }
    // 最后一行
    for (int c = cols - 2; c >= 0; c--) {
      if (dungeon[rows - 1][c] > 0) {
        dp[rows - 1][c] = dp[rows - 1][c + 1] + dungeon[rows - 1][c];
      } else {
        if (dp[rows - 1][c + 1] < 0) {
          dp[rows - 1][c] = dp[rows - 1][c + 1] + dungeon[rows - 1][c];
        } else {
          dp[rows - 1][c] = dungeon[rows - 1][c];
        }
      }
    }
    // 向上汇总
    for (int r = rows - 2; r >= 0; r--) {
      for (int c = cols - 2; c >= 0; c--) {
        int base = Math.max(dp[r][c + 1], dp[r + 1][c]);
        if (dungeon[r][c] > 0) {
          dp[r][c] = base + dungeon[r][c];
        } else {
          if (base < 0) {
            dp[r][c] = base + dungeon[r][c];
          } else {
            dp[r][c] = dungeon[r][c];
          }
        }
      }
    }
    return dp[0][0] > 0 ? 0 : 1 - dp[0][0];
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0174_DungeonGame().calculateMinimumHP(new int[][]{
      {-2, -3, 3},
      {-5, -10, 1},
      {10, 30, -5}});
  }
}
