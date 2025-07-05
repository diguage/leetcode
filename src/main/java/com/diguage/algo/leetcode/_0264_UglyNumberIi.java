package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _0264_UglyNumberIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-05 23:32:25
   */
  public int nthUglyNumber(int n) {
    int[] bases = new int[]{2, 3, 5};
    Set<Long> nums = new HashSet<>();
    Queue<Long> queue = new PriorityQueue<>();
    nums.add(1L);
    queue.add(1L);
    for (int i = 1; i <= n; i++) {
      long item = queue.poll();
      if (i == n) {
        return (int) item;
      }
      for (int base : bases) {
        long next = base * item;
        if (!nums.contains(next)) {
          nums.add(next);
          queue.add(next);
        }
      }
    }
    return -1;
  }
  // end::answer[]
}
