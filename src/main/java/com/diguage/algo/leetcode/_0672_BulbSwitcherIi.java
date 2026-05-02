package com.diguage.algo.leetcode;

public class _0672_BulbSwitcherIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-02 21:42:55
   */
  public int flipLights(int n, int presses) {
    // 不按开关
    if (presses == 0) {
      return 1;
    }
    //特殊情况处理
    if (n == 1) {
      return 2;
    } else if (n == 2) {
      //特殊情况
      return presses == 1 ? 3 : 4;
    } else {
      //n >= 3
      return presses == 1 ? 4 : presses == 2 ? 7 : 8;
    }
  }
  // end::answer[]
}
