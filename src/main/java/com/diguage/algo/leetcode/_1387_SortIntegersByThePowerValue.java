package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1387_SortIntegersByThePowerValue {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-27 19:55:53
   */
  public int getKth(int lo, int hi, int k) {
    int length = hi - lo + 1;
    int[] step = new int[length];
    for (int i = lo; i <= hi; i++) {
      step[i - lo] = calc(i);
    }
    List<Integer> index = new ArrayList<>(length);
    for (int i = 0; i < length; i++) {
      index.add(i);
    }
    index.sort((a, b) -> {
      int result = Integer.compare(step[a], step[b]);
      if (result == 0) {
        return Integer.compare(a, b);
      } else {
        return result;
      }
    });
    return index.get(k - 1) + lo;
  }

  private int calc(int num) {
    int result = 0;
    while (num > 1) {
      if ((num & 1) == 0) {
        num /= 2;
      } else {
        num = 3 * num + 1;
      }
      result++;
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1387_SortIntegersByThePowerValue().getKth(7, 11, 4);
  }
}
