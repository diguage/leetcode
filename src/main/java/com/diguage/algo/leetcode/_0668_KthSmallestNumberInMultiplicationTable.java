package com.diguage.algo.leetcode;

public class _0668_KthSmallestNumberInMultiplicationTable {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-30 21:13:18
   */
  public int findKthNumber(int m, int n, int k) {
    int left = 0, right = m * n;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (check(m, n, k, mid)) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return right;
  }

  private boolean check(int m, int n, int k, int x) {
    int cnt = 0;
    for (int i = 1; i <= m; i++) {
      cnt += Math.min(x / i, n);
    }
    return cnt >= k;
  }
  // end::answer[]
}
