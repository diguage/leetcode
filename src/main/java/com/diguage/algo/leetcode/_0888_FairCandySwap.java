package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _0888_FairCandySwap {

  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-27 22:18:16
   */
  public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    int as = Arrays.stream(aliceSizes).sum();
    int bs = Arrays.stream(bobSizes).sum();
    int diff = (as - bs) / 2;
    Set<Integer> set = new HashSet<>();
    for (int b : bobSizes) {
      set.add(b);
    }
    int[] result = new int[2];
    for (int a : aliceSizes) {
      int b = a - diff;
      if (set.contains(b)) {
        result[0] = a;
        result[1] = b;
        break;
      }
    }
    return result;
  }
  // end::answer[]
}
