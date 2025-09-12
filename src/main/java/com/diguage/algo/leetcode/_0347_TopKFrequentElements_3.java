package com.diguage.algo.leetcode;

import java.util.*;

public class _0347_TopKFrequentElements_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-12 22:32:37
   */
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
    for (Integer key : map.keySet()) {
      if (queue.size() < k) {
        queue.offer(key);
      } else if (map.get(key) > map.get(queue.peek())) {
        queue.poll();
        queue.offer(key);
      }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = queue.poll();
    }
    return result;
  }
  // end::answer[]
}
