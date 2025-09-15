package com.diguage.algo.leetcode;

import java.util.PriorityQueue;

public class _0295_FindMedianFromDataStream_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-15 21:36:06
   */
  class MedianFinder {

    private PriorityQueue<Integer> topSmall;
    private PriorityQueue<Integer> topLarge;

    public MedianFinder() {
      topSmall = new PriorityQueue<>();
      topLarge = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
      if (topLarge.size() == topSmall.size()) {
        topSmall.offer(num);
        topLarge.offer(topSmall.poll());
      } else {
        topLarge.offer(num);
        topSmall.offer(topLarge.poll());
      }
    }

    public double findMedian() {
      if (topLarge.size() == topSmall.size()) {
        return (topLarge.peek() + topSmall.peek()) / 2.0;
      } else {
        return topLarge.peek();
      }
    }
  }
  // end::answer[]
}
