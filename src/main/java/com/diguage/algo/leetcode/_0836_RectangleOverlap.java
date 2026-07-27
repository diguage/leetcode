package com.diguage.algo.leetcode;

public class _0836_RectangleOverlap {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-27 23:03:45
   */
  public boolean isRectangleOverlap(int[] a, int[] b) {
    // 投影到 x, y 轴上，画图理解
    int ax1 = a[0], ay1 = a[1], ax2 = a[2], ay2 = a[3];
    int bx1 = b[0], by1 = b[1], bx2 = b[2], by2 = b[3];
    return Math.max(ax1, bx1) < Math.min(ax2, bx2)
      && Math.max(ay1, by1) < Math.min(ay2, by2);
  }
  // end::answer[]
}
