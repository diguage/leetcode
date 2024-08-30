package com.diguage.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class _0295_FindMedianFromDataStream {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-29 20:43:20
   */
  class MedianFinder {
    Queue<Integer> topSmall;
    Queue<Integer> topLarge;

    public MedianFinder() {
      // 小顶堆，顶部是最小的。保存较大的一半
      topSmall = new PriorityQueue<>();
      // 大顶堆，顶部是最大的。保存较小的一半
      topLarge = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
      if (topSmall.size() != topLarge.size()) {
        // 倒腾一下，实际 topLarge 中的元素增加了
        topSmall.add(num);
        topLarge.add(topSmall.poll());
      } else {
        // 倒腾一下，实际 topSmall 中的元素增加了
        topLarge.add(num);
        topSmall.add(topLarge.poll());
      }
    }

    public double findMedian() {
      return topSmall.size() != topLarge.size() ? topSmall.peek() : (topSmall.peek() + topLarge.peek()) / 2.0;
    }
  }
  // end::answer[]
}
