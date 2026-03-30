package com.diguage.algo.leetcode;

public class _0598_RangeAdditionIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-30 20:53:49
   */
  public int maxCount(int m, int n, int[][] ops) {
    for (int[] op : ops) {
      m = Integer.min(m, op[0]);
      n = Integer.min(n, op[1]);
    }
    return m * n;
  }
  // end::answer[]
}
