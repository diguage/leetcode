package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1349_MaximumStudentsTakingExam_2b {
  // tag::answer[]

  /**
   * 暴力破解（50/57）-> 备忘录（100.00%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-24 22:55
   */
  public int maxStudents(char[][] seats) {
    int m = seats.length;
    int n = seats[0].length;
    int[] a = new int[m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (seats[i][j] == '.') {
          a[i] |= 1 << j;
        }
      }
    }
    int[][] memo = new int[m][1 << n];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return dfs(m - 1, a[m - 1], a, memo);
  }

  private int dfs(int i, int j, int[] a, int[][] memo) {
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    if (i == 0) {
      if (j == 0) {
        return 0;
      }
      int lb = j & -j;
      return memo[i][j] = dfs(i, j & ~(lb * 3), a, memo) + 1;
    }
    int result = dfs(i - 1, a[i - 1], a, memo);
    for (int s = j; s > 0; s = (s - 1) & j) {
      if ((s & (s >> 1)) == 0) {
        int t = a[i - 1] & ~(s << 1 | s >> 1);
        result = Math.max(result, dfs(i - 1, t, a, memo) + Integer.bitCount(s));
      }
    }
    return memo[i][j] = result;
  }
  // end::answer[]
}
