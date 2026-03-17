package com.diguage.algo.leetcode;

import java.util.Map;

public class _0564_FindTheClosestPalindrome {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-17 20:23:41
   */
  private long min = Long.MAX_VALUE;
  private long result;

  public String nearestPalindromic(String n) {
    long num = Long.parseLong(n);
    int m = n.length(); // num 的十进制长度
    update((long) Math.pow(10, m - 1) - 1, num); // 十进制长为 m-1 的最大回文数
    update((long) Math.pow(10, m) + 1, num); // 十进制长为 m+1 的最小回文数
    int left = Integer.parseInt(n.substring(0, (m + 1) / 2));
    for (int l = left-1; l <= left + 1; l++) {
      long palindromic = l;
      for (int x = m % 2 > 0 ? l / 10 : l; x > 0; x /= 10) {
        palindromic = palindromic * 10 + (x % 10);
      }
      update(palindromic, num);
    }
    return Long.toString(result);
  }

  private void update(long palindromic, long num) {
    long d = Math.abs(palindromic - num);
    if (d > 0 && (d < min || d == min && palindromic < result)) {
      min = d;
      result = palindromic;
    }
  }
  // end::answer[]
}
