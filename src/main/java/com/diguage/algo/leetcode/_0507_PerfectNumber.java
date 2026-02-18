package com.diguage.algo.leetcode;

public class _0507_PerfectNumber {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-18 08:20:11
   */
  public boolean checkPerfectNumber(int num) {
    if (num == 1) {
      return false;
    }
    int sum = 1;
    for (int i = 2; i < num; i++) {
      int temp = num / i;
      if (temp < i) {
        break;
      }
      if (temp * i == num) {
        sum += i;
        if (temp != i) {
          sum += temp;
        }
      }
      if (sum > num) {
        return false;
      }
    }
    return sum == num;
  }
  // end::answer[]
  static void main() {
    new _0507_PerfectNumber().checkPerfectNumber(6);
  }
}
