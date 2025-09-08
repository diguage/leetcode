package com.diguage.algo.leetcode;

public class _0202_HappyNumber_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-08 19:17:10
   */
  public boolean isHappy(int n) {
    int slow = n, fast = n;
    do {
      slow = calc(slow);
      fast = calc(fast);
      fast = calc(fast);
      if (fast == 1) {
        return true;
      }
    } while (fast != slow);
    return false;
  }

  private int calc(int n) {
    int result = 0;
    while (n != 0) {
      int mod = n % 10;
      result += mod * mod;
      n /= 10;
    }
    return result;
  }
  // end::answer[]
}
