package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0347_TopKFrequentElements_21 {
  // tag::answer[]
  /**
   * 桶排序
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-26 14:56:31
   */
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numToCountMap = new HashMap<>();
    int maxCount = 0;
    for (int num : nums) {
      Integer count = numToCountMap.getOrDefault(num, 0);
      Integer newCnt = ++count;
      if (newCnt > maxCount) {
        maxCount = newCnt;
      }
      numToCountMap.put(num, newCnt);
    }
    List<Integer>[] buckets = new ArrayList[maxCount + 1];
    numToCountMap.forEach((key, v) -> {
      if (buckets[v] == null) {
        buckets[v] = new ArrayList<>();
      }
      buckets[v].add(key);
    });
    int[] result = new int[k];
    for (int i = maxCount; i >= 0 && k > 0; i--) {
      if (buckets[i] != null) {
        for (int num : buckets[i]) {
          result[--k] = num;
        }
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0347_TopKFrequentElements_21().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
  }
}
