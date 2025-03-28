package com.diguage.algo.leetcode;

import java.util.PriorityQueue;

public class _0295_FindMedianFromDataStream_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-28 18:53:57
   */
  class MedianFinder {
    // 小顶堆，顶部是最小的。保存较大的一半
    PriorityQueue<Integer> topSmall;
    // 大顶堆，顶部是最大的。保存较小的一半
    PriorityQueue<Integer> topLarge;

    public MedianFinder() {
      topSmall = new PriorityQueue<>();
      // 注意：这里的 Comparator 是反向，不能直接用 Integer::compare 代替
      topLarge = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
      if (topSmall.size() == topLarge.size()) {
        topLarge.offer(num);
        topSmall.offer(topLarge.poll());
      } else {
        topSmall.offer(num);
        topLarge.offer(topSmall.poll());
      }
    }

    public double findMedian() {
      return topSmall.size() == topLarge.size()
        ? (topSmall.peek() + topLarge.peek()) / 2.0 : topSmall.peek();
    }
  }

  // end::answer[]
  public MedianFinder newInstance() {
    return new MedianFinder();
  }

  public static void main(String[] args) {
    _0295_FindMedianFromDataStream_3 instance = new _0295_FindMedianFromDataStream_3();
    MedianFinder finder = instance.newInstance();
    finder.addNum(6);
    System.out.println(finder.findMedian());
    finder.addNum(10);
    System.out.println(finder.findMedian());
    finder.addNum(2);
    System.out.println(finder.findMedian());
    finder.addNum(6);
    System.out.println(finder.findMedian());
    finder.addNum(5);
    System.out.println(finder.findMedian());
    finder.addNum(0);
    System.out.println(finder.findMedian());
    finder.addNum(6);
    System.out.println(finder.findMedian());
    finder.addNum(3);
    System.out.println(finder.findMedian());
    finder.addNum(1);
    System.out.println(finder.findMedian());
    finder.addNum(0);
    System.out.println(finder.findMedian());
    finder.addNum(0);
    System.out.println(finder.findMedian());
  }
}
