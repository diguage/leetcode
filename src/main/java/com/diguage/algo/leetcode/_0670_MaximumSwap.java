package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0670_MaximumSwap {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-28 23:00:28
   */
  public int maximumSwap(int num) {
    List<Integer> digits = getDigits(num);
    if (digits.size() < 2) {
      return num;
    }
    // 不标注是否交换，只击败了 31%，加后，击败 100%
    boolean swapped = false;
    for (int i = digits.size() - 1; i > 0; i--) {
      int idx = getMaxNumIndex(digits, i - 1);
      if (digits.get(idx) > digits.get(i)) {
        int tmp = digits.get(i);
        digits.set(i, digits.get(idx));
        digits.set(idx, tmp);
        swapped = true;
        break;
      }
    }
    if (swapped) {
      return digitToNum(digits);
    } else {
      return num;
    }
  }

  private int digitToNum(List<Integer> digits) {
    int result = digits.getLast();
    for (int i = digits.size() - 2; i >= 0; i--) {
      result *= 10;
      result += digits.get(i);
    }
    return result;
  }

  private int getMaxNumIndex(List<Integer> digits, int index) {
    int max = Integer.MIN_VALUE;
    int result = -1;
    for (int i = 0; i <= index; i++) {
      if (max < digits.get(i)) {
        max = digits.get(i);
        result = i;
      }
    }
    return result;
  }

  private List<Integer> getDigits(int num) {
    List<Integer> result = new ArrayList<>();
    if (num == 0) {
      result.add(0);
      return result;
    }
    while (num > 0) {
      int digit = num % 10;
      result.add(digit);
      num /= 10;
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0670_MaximumSwap().maximumSwap(2736);
  }
}
