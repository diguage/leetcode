package com.diguage.algo.leetcode;

public class _0799_ChampagneTower {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-28 22:00:23
   */
  public double champagneTower(int poured, int query_row, int query_glass) {
    double[] parent = {poured};
    for (int i = 1; i <= query_row; i++) {
      double[] children = new double[i + 1];
      for (int j = 0; j < i; j++) {
        double volume = parent[j];
        if (volume > 1) {
          children[j] += (volume - 1) / 2;
          children[j + 1] = (volume - 1) / 2;
        }
      }
      parent = children;
    }
    return Math.min(1, parent[query_glass]);
  }
  // end::answer[]
  static void main() {
    new _0799_ChampagneTower().champagneTower(1, 1, 1);
  }
}
