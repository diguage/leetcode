package com.diguage.algo.leetcode;

import java.util.PriorityQueue;

public class _0703_KthLargestElementInAStream {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-01 15:22:49
   */
  class KthLargest {
    // 无需保留所有元素，只需一个优先队列即可。
    private PriorityQueue<Integer> topLargestQueue
      = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    private PriorityQueue<Integer> topSmallestQueue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
      for (int num : nums) {
        topSmallestQueue.offer(num);
        if (topSmallestQueue.size() < k) {
          continue;
        }
        topLargestQueue.offer(topSmallestQueue.poll());
      }
    }

    public int add(int val) {
      topSmallestQueue.offer(val);
      topLargestQueue.offer(topSmallestQueue.poll());
      return topLargestQueue.peek();
    }
  }

  // end::answer[]
//  static void main() {
//    KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
//    System.out.println(k.add(3));
//    System.out.println(k.add(5));
//    System.out.println(k.add(10));
//    System.out.println(k.add(9));
//    System.out.println(k.add(4));
//  }
}
