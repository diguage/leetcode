package com.diguage.algo.leetcode;

public class _0667_BeautifulArrangementIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-29 22:52:58
   */
  public int[] constructArray(int n, int k) {
    int[] result = new int[n];
    int idx = 0;
    for (int i = 1; i < n - k; i++) {
      result[idx++] = i;
    }
    for (int i = n - k, j = n; i <= j; i++, j--) {
      result[idx++] = i;
      if (i != j) {
        result[idx++] = j;
      }
    }
    return result;
  }
  // end::answer[]
}
