package com.diguage.algo.leetcode;

import java.util.*;

public class _0347_TopKFrequentElements_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-15 10:35:28
   */
  public int[] topKFrequent(int[] nums, int k) {
    int max = Integer.MIN_VALUE;
    Map<Integer, Integer> counter = new HashMap<>();
    for (int num : nums) {
      int value = counter.getOrDefault(num, 0) + 1;
      counter.put(num, value);
      max = Math.max(max, value);
    }
    List<Integer>[] bucket = new List[max + 1];
    for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
      if (Objects.isNull(bucket[entry.getValue()])) {
        bucket[entry.getValue()] = new ArrayList<>();
      }
      bucket[entry.getValue()].add(entry.getKey());
    }
    int[] result = new int[k];
    int index = 0;
    for (int i = max; i >= 0 && index < k; i--) {
      if (bucket[i] == null) {
        continue;
      }
      for (Integer integer : bucket[i]) {
        result[index++] = integer;
        if (index == k) {
          break;
        }
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0347_TopKFrequentElements_4().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
  }
}
