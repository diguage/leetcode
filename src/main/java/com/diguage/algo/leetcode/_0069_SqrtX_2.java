package com.diguage.algo.leetcode;

public class _0069_SqrtX_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-27 00:05:40
   */
  public int mySqrt(int x) {
    int left = 0, right = x, result = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if ((long) mid * mid <= x) {
        result = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0069_SqrtX_2().mySqrt(2147395599);
  }
}
