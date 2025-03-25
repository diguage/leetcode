package com.diguage.algo.leetcode;

import java.util.*;

public class _0347_TopKFrequentElements_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-25 21:20:04
   */
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numToCountMap = new HashMap<>();
    for (int num : nums) {
      Integer count = numToCountMap.getOrDefault(num, 0);
      numToCountMap.put(num, ++count);
    }
    // 寻找最频繁的 K 个元素，这里就要用最小堆。
    // 注意：堆里比较的是元素出现的次数，不是元素本身，所以自定义比较器
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(numToCountMap::get));
    for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
      Integer num = entry.getKey();
      Integer count = entry.getValue();
      if (minHeap.size() < k) {
        minHeap.offer(num);
      } else {
        if (numToCountMap.get(minHeap.peek()) < count) {
          minHeap.poll();
          minHeap.offer(num);
        }
      }
    }
    int[] result = new int[k];
    for (int num : minHeap) {
      result[--k] = num;
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0347_TopKFrequentElements_2().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
  }
}
