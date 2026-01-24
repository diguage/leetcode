package com.diguage.algo.leetcode;

public class _1349_MaximumStudentsTakingExam_2a {
  // tag::answer[]
  /**
   * 暴力破解（50/57）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-24 22:13:43
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
    return dfs(m - 1, a[m - 1], a);
  }

  private int dfs(int i, int j, int[] a) {
    if (i == 0) {
      if (j == 0) {
        return 0;
      }
      int lb = j & -j;
      return dfs(i, j & ~(lb * 3), a) + 1;
    }
    int result = dfs(i - 1, a[i - 1], a);
    for (int s = j; s > 0; s = (s - 1) & j) {
      if ((s & (s >> 1)) == 0) {
        int t = a[i - 1] & ~(s << 1 | s >> 1);
        result = Math.max(result, dfs(i - 1, t, a) + Integer.bitCount(s));
      }
    }
    return result;
  }
  // end::answer[]
}
