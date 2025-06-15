package com.diguage.algo.leetcode;

import java.util.*;

public class _0373_FindKPairsWithSmallestSums {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-15 23:12:43
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, (a, b) ->
      Long.compare((long) b.getFirst() + b.getLast(), (long) a.getFirst() + a.getLast()));
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        if (pq.size() < k) {
          pq.add(Arrays.asList(nums1[i], nums2[j]));
          continue;
        }
        long sum = (long) nums1[i] + nums2[j];
        List<Integer> head = pq.peek();
        long headSum = (long) head.getFirst() + head.getLast();
        if (sum < headSum) {
          pq.poll();
          pq.offer(Arrays.asList(nums1[i], nums2[j]));
        } else {
          break;
        }
      }
    }
    return new ArrayList<>(pq);
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0373_FindKPairsWithSmallestSums()
      .kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 2);
  }
}
