package com.diguage.algo.leetcode;

public class _0504_Base7 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-16 21:50:17
   */
  public String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }
    String prefix = num >= 0 ? "" : "-";
    StringBuilder sb = new StringBuilder();
    num = Math.abs(num);
    while (num > 0) {
      sb.append(num % 7);
      num /= 7;
    }
    sb.append(prefix);
    sb.reverse();
    return sb.toString();
  }
  // end::answer[]
}
