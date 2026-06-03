package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0738_MonotoneIncreasingDigits {

  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-03 19:26:03
   */
  public int monotoneIncreasingDigits(int n) {
    if (n == 0) {
      return 0;
    }
    List<Integer> bits = new ArrayList<>();
    while (n > 0) {
      bits.add(n % 10);
      n = n / 10;
    }
    bits = bits.reversed();
    int max = -1, index = -1;
    for (int i = 0; i < bits.size() - 1; i++) {
      if (max < bits.get(i)) {
        max = bits.get(i);
        index = i;
      }
      if (bits.get(i) > bits.get(i + 1)) {
        bits.set(index, bits.get(index) - 1);
        for (int j = index + 1; j < bits.size(); j++) {
          bits.set(j, 9);
        }
        break;
      }
    }
    int result = 0;
    for (Integer b : bits) {
      result *= 10;
      result += b;
    }
    return result;
  }
  // end::answer[]
}
