package com.diguage.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class _0295_FindMedianFromDataStream_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 16:37:23
   */
  class MedianFinder {
    Queue<Integer> topSmall;
    Queue<Integer> topLarge;

    public MedianFinder() {
      // 小顶堆，顶部是最小的。保存较大的一半
      topSmall = new PriorityQueue<>();
      // 大顶堆，顶部是最大的。保存较小的一半
      topLarge = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
      if (topSmall.size() != topLarge.size()) {
        topSmall.offer(num);
        topLarge.offer(topSmall.poll());
      } else {
        topLarge.offer(num);
        topSmall.offer(topLarge.poll());
      }
    }

    public double findMedian() {
      return topSmall.size() == topLarge.size() ?
        (topSmall.peek() + topLarge.peek()) / 2.0 : topSmall.peek();
    }
  }
  // end::answer[]
}
