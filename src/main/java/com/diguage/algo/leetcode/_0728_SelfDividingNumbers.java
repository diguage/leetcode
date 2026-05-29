package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0728_SelfDividingNumbers {

  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-29 22:36:32
   */
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> result = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      if (isSelfDividing(i)) {
        result.add(i);
      }
    }
    return result;
  }

  private boolean isSelfDividing(int i) {
    int cur = i;
    while (cur != 0) {
      int digit = cur % 10;
      if (digit == 0 || i % digit != 0) {
        return false;
      }
      cur /= 10;
    }
    return true;
  }
  // end::answer[]
}
