package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0556_NextGreaterElementIii {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-12 23:02:04
   */
  public int nextGreaterElement(int n) {
    int[] digits = getDigits(n);
    if (digits.length == 1) {
      return -1;
    }
    int small = -1;
    for (int i = digits.length - 2; i >= 0; i--) {
      if (digits[i] < digits[i + 1]) {
        small = i;
        break;
      }
    }
    if (small == -1) {
      return -1;
    }
    int big = -1;
    for (int i = digits.length - 1; i >= small; i--) {
      if (digits[i] > digits[small]) {
        big = i;
        break;
      }
    }
    Integer si = digits[small];
    digits[small] = digits[big];
    digits[big] = si;
    Arrays.sort(digits, small + 1, digits.length);
    int result = digits[0];
    for (int i = 1; i < digits.length; i++) {
      result *= 10;
      result += digits[i];
    }
    return result > n ? result : -1;
  }

  private int[] getDigits(int n) {
    List<Integer> digits = new ArrayList<>();
    while (n > 0) {
      digits.add(n % 10);
      n /= 10;
    }
    Collections.reverse(digits);
    int[] result = new int[digits.size()];
    for (int i = 0; i < digits.size(); i++) {
      result[i] = digits.get(i);
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0556_NextGreaterElementIii()
      .nextGreaterElement(72654);
  }
}
