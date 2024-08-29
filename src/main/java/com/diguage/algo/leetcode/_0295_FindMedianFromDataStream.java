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
    Queue<Integer> big;
    Queue<Integer> small;

    public MedianFinder() {
      // 小顶堆，顶部是最小的。保存较大的一半
      big = new PriorityQueue<>();
      // 大顶堆，顶部是最大的。保存较小的一半
      small = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
      if (big.size() != small.size()) {
        // 倒腾一下，实际 small 中的元素增加了
        big.add(num);
        small.add(big.poll());
      } else {
        // 倒腾一下，实际 big 中的元素增加了
        small.add(num);
        big.add(small.poll());
      }
    }

    public double findMedian() {
      return big.size() != small.size() ? big.peek() : (big.peek() + small.peek()) / 2.0;
    }
  }
  // end::answer[]
}
