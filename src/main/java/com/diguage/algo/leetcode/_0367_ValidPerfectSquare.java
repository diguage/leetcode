package com.diguage.algo.leetcode;

public class _0367_ValidPerfectSquare {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-20 22:20:06
   */
  public boolean isPerfectSquare(int num) {
    if (num <= 0) {
      return false;
    }
    if (num == 1) {
      return true;
    }
    int left = 1, right = num / 2;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long pow = ((long) mid) * mid;
      if (pow == num) {
        return true;
      } else if (pow > num) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return false;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0367_ValidPerfectSquare().isPerfectSquare(2147395600);
  }
}
