package com.diguage.algo.leetcode;

public class _0552_StudentAttendanceRecordIi_1b {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-09 23:20:57
   */
  public int checkRecord(int n) {
    int MOD = 1_000_000_007;
    int[][][] memo = new int[n + 1][2][3];
    return dfs(n, 0, 0, MOD, memo);
  }

  private int dfs(int i, int j, int k,
                  final int MOD, int[][][] memo) {
    if (i == 0) {
      return 1;
    }
    if (memo[i][j][k] > 0) {
      return memo[i][j][k];
    }
    long result = dfs(i - 1, j, 0, MOD, memo);
    if (j == 0) {
      result += dfs(i - 1, 1, 0, MOD, memo);
    }
    if (k < 2) {
      result += dfs(i - 1, j, k + 1, MOD, memo);
    }
    return memo[i][j][k] = (int) (result % MOD);
  }
  // end::answer[]
}
