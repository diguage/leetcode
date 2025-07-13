package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0319_BulbSwitcher {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-13 23:19:46
   */
  public int bulbSwitch(int n) {
    boolean[] ligths = new boolean[n + 1];
    Arrays.fill(ligths, true);
    int step = 2;
    for (int i = 2; i <= n; i++) {
      for (int j = step; j <= n; j += step) {
        ligths[j] = !ligths[j];
      }
      step++;
    }
    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (ligths[i]) {
        result++;
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0319_BulbSwitcher().bulbSwitch(9999999);
  }
}
