package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0517_SuperWashingMachines {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-20 13:56:55
   */
  public int findMinMoves(int[] machines) {
    int sum = Arrays.stream(machines).sum();
    if (sum % machines.length != 0) {
      return -1;
    }
    int result = 0, presum = 0;
    int avg = sum / machines.length;
    for (int i = 0; i < machines.length; i++) {
      presum += machines[i];
      result = Math.max(result,
        Math.max(machines[i] - avg,
          Math.abs(presum - avg * (i + 1))));
    }
    return result;
  }
  // end::answer[]
}
