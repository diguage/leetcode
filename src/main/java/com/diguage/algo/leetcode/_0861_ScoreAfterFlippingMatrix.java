package com.diguage.algo.leetcode;

public class _0861_ScoreAfterFlippingMatrix {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-12 22:30:19
   */
  public int matrixScore(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    // 确保第一行都是 1
    for (int[] row : grid) {
      if (row[0] == 1) {
        continue;
      }
      for (int i = 0; i < n; i++) {
        row[i] ^= 1;
      }
    }
    // 确保每一列的 1 占多数
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int[] ints : grid) {
        cnt += ints[i];
      }
      if (m / 2 < cnt) {
        continue;
      }
      for (int j = 0; j < m; j++) {
        grid[j][i] ^= 1;
      }
    }
    // 转成数字。⚠️：这一步可以和上一步合并，减少一次循环
    int result = 0;
    for (int[] row : grid) {
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        cnt = cnt * 2 + row[i];
      }
      result += cnt;
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0861_ScoreAfterFlippingMatrix()
//      .matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}});
      .matrixScore(new int[][]{{0, 1}, {1, 1}});
  }
}
