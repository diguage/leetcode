package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _0788_RotatedDigits {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-21 21:58:49
   */
  private static int[] counter = new int[10_001];
  private static Map<Integer, Integer> items = Map.of(
    0, 0,
    1, 1,
    2, 5, 5, 2,
    6, 9, 9, 6,
    8, 8);

  static {
    int cnt = 0;
    for (int i = 1; i <= 10_000; i++) {
      int curr = i;
      List<Integer> digits = new ArrayList<>();
      while (curr != 0) {
        int digit = curr % 10;
        Integer rd = items.get(digit);
        if (rd == null) {
          digits.clear();
          break;
        } else {
          digits.add(rd);
        }
        curr /= 10;
      }
      int num = 0;
      for (Integer integer : digits.reversed()) {
        num *= 10;
        num += integer;
      }
      if (num > 0 && num != i) {
        cnt++;
      }
      counter[i] = cnt;
    }
  }

  public int rotatedDigits(int n) {
    return counter[n];
  }

  // end::answer[]
  static void main() {
    new _0788_RotatedDigits().rotatedDigits(10);
  }
}

