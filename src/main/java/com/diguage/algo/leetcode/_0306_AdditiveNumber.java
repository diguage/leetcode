package com.diguage.algo.leetcode;

import java.math.BigInteger;

public class _0306_AdditiveNumber {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-09 21:06:37
   */
  public boolean isAdditiveNumber(String num) {
    if (num == null || num.length() < 3) {
      return false;
    }
    int length = num.length();
    for (int i = 1; i <= length / 2; i++) {
      for (int j = i + 1; j <= 2 * length / 3; j++) {
        boolean ok = dfs(num, 0, i, i, j);
        if (ok) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(String num,
                                   int firstStart, int firstEnd,
                                   int secondStart, int secondEnd) {
    if (secondEnd == num.length()) {
      return true;
    }
    if ((firstEnd - firstStart > 1 && num.charAt(firstStart) == '0')
      || (secondEnd - secondStart > 1 && num.charAt(secondStart) == '0')) {
      return false;
    }
    BigInteger first = new BigInteger(num.substring(firstStart, firstEnd));
    BigInteger second = new BigInteger(num.substring(secondStart, secondEnd));
    BigInteger next = first.add(second);
    String nextString = next.toString();
    int nextEnd = secondEnd + nextString.length();
    if (nextEnd > num.length()) {
      return false;
    }
    String substring = num.substring(secondEnd, nextEnd);
    if (nextString.contains(substring)) {
      return dfs(num, secondStart, secondEnd, secondEnd, nextEnd);
    }
    return false;
  }
  // end::answer[]

  public static void main(String[] args) {
    System.out.println(new _0306_AdditiveNumber().isAdditiveNumber("199111992"));
  }
}
