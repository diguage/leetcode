package com.diguage.algo.leetcode;

public class _0223_RectangleArea {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-01 17:28:11
   */
  public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int overx = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
    int overy = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
    return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - overx * overy;
  }
  // end::answer[]
}
