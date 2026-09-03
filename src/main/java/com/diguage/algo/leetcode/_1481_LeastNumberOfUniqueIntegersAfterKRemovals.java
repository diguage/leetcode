package com.diguage.algo.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1481_LeastNumberOfUniqueIntegersAfterKRemovals {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-03 21:12:52
   */
  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int i : arr) {
      cnt.put(i, cnt.getOrDefault(i, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator
      .comparingInt(a -> cnt.getOrDefault(a, 0)));
    for (Integer n : cnt.keySet()) {
      pq.offer(n);
    }
    while (k > 0) {
      Integer n = pq.poll();
      Integer c = cnt.get(n);
      if (k >= c) {
        cnt.remove(n);
        k -= c;
      } else {
        cnt.put(n, c - k);
        k = 0;
      }
    }
    return cnt.keySet().size();
  }
  // end::answer[]
  static void main() {
    new _1481_LeastNumberOfUniqueIntegersAfterKRemovals()
      .findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3);
  }
}
