package com.diguage.algo.leetcode;

public class _0319_BulbSwitcher {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-13 23:19:46
   */
  public int bulbSwitch(int n) {
    return (int) Math.sqrt(n);
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0319_BulbSwitcher().bulbSwitch(9999999);
  }
}
