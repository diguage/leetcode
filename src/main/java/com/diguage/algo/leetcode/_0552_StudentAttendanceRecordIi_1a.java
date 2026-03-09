package com.diguage.algo.leetcode;

public class _0552_StudentAttendanceRecordIi_1a {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-09 23:06:57
   */
  public int checkRecord(int n) {
    int MOD = 10_000_000;
    return dfs(MOD, n, 0, 0);
  }

  private int dfs(final int MOD,
                  int i, int j, int k) {
    if (i == 0) {
      return 1;
    }
    long result = dfs(MOD, i - 1, j, 0);
    if (j == 0) {
      result += dfs(MOD, i - 1, 1, 0);
    }
    if (k < 2) {
      result += dfs(MOD, i - 1, j, k + 1);
    }
    return (int) (result % MOD);
  }
  // end::answer[]
}
