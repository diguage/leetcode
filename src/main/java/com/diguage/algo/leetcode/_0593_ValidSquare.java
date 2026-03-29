package com.diguage.algo.leetcode;

public class _0593_ValidSquare {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-29 19:47:52
   */
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    if (!isValid(p1, p2, p3, p4)) {
      return false;
    }
    if (!isValid(p2, p3, p4, p1)) {
      return false;
    }
    if (!isValid(p3, p4, p1, p2)) {
      return false;
    }
    if (!isValid(p4, p1, p2, p3)) {
      return false;
    }
    return true;
  }

  private boolean isValid(int[] p1, int[] p2, int[] p3, int[] p4) {
    int l1 = calcLen(p1, p2);
    int l2 = calcLen(p1, p3);
    int l3 = calcLen(p1, p4);
    int min = Math.min(l1, Math.min(l2, l3));
    int max = Math.max(l1, Math.max(l2, l3));
    if (2 * min != max || min == max) {
      return false;
    }
    if (l1 != min && l1 != max) {
      return false;
    }
    if (l2 != min && l2 != max) {
      return false;
    }
    if (l3 != min && l3 != max) {
      return false;
    }
    return true;
  }

  private int calcLen(int[] p1, int[] p2) {
    int x = p2[0] - p1[0];
    int y = p2[1] - p1[1];
    return x * x + y * y;
  }
  // end::answer[]
}
