package com.diguage.algo.leetcode;

public class _0441_ArrangingCoins {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-14 22:55:09
   */
  public int arrangeCoins(int n) {
    if (n <= 1) {
      return n;
    }
    int left = (int) (Math.sqrt(2) * Math.sqrt(n)) - 1, right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      long num = ((long) mid) * (mid + 1) / 2;
      if (num == n) {
        return mid;
      } else if (num < n) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left - 1;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0441_ArrangingCoins().arrangeCoins(2);
  }
}
