package com.diguage.algo.leetcode;

import java.util.PriorityQueue;

public class _0786_KThSmallestPrimeFraction {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-20 21:28:40
   */
  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    PriorityQueue<int[]> queue = new PriorityQueue<>(k + 1,
      (a, b) -> Long.compare((long) a[1] * b[0], (long) a[0] * b[1]));
    for (int i = 0; i < arr.length; i++) {
      for (int j = arr.length - 1; j > i; j--) {
        queue.offer(new int[]{arr[i], arr[j]});
        if (queue.size() > k) {
          queue.poll();
        }
      }
    }
    return queue.poll();
  }

  // end::answer[]
  static void main() {
    new _0786_KThSmallestPrimeFraction()
      .kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
  }
}
