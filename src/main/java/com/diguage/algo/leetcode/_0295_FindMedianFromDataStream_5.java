package com.diguage.algo.leetcode;

import java.util.Objects;
import java.util.PriorityQueue;

public class _0295_FindMedianFromDataStream_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-16 22:12:35
   */
  class MedianFinder {
    private final PriorityQueue<Integer> topSmallHeap;
    private final PriorityQueue<Integer> topLargeHeap;

    public MedianFinder() {
      topSmallHeap = new PriorityQueue<>();
      topLargeHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
      if (Objects.equals(topSmallHeap.size(), topLargeHeap.size())) {
        topLargeHeap.offer(num);
        topSmallHeap.offer(topLargeHeap.poll());
      } else {
        topSmallHeap.offer(num);
        topLargeHeap.offer(topSmallHeap.poll());
      }
    }

    public double findMedian() {
      if (Objects.equals(topSmallHeap.size(), topLargeHeap.size())) {
        return (0.0D + topLargeHeap.peek() + topSmallHeap.peek()) / 2.0;
      } else {
        return topSmallHeap.peek();
      }
    }
  }
  // end::answer[]
}
