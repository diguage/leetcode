package com.diguage.algo.leetcode;

import java.util.*;

public class _0480_SlidingWindowMedian_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-16 22:41:00
   */
  public double[] medianSlidingWindow(int[] nums, int k) {
    List<Double> result = new ArrayList<>();
    MedianFinder finder = new MedianFinder();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      finder.addNum(num);
      if (finder.size() < k) {
        continue;
      }
      result.add(finder.findMedian());
      int deleted = nums[i - k + 1];
      finder.deleteNum(deleted);
    }
    return result.stream().mapToDouble(i -> i).toArray();
  }

  private static class MedianFinder {
    private final PriorityQueue<Integer> topSmallHeap;
    private final PriorityQueue<Integer> topLargeHeap;
    private int topSmallSize;
    private int topLargeSize;
    private Map<Integer, Integer> waitDelateNum;

    public MedianFinder() {
      topSmallHeap = new PriorityQueue<>();
      topSmallSize = 0;
      topLargeHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
      topLargeSize = 0;
      waitDelateNum = new HashMap<>();
    }

    public void addNum(int num) {
      if (Objects.equals(topSmallSize, topLargeSize)) {
        deleteTop(topLargeHeap);
        topLargeHeap.offer(num);
        topSmallHeap.offer(topLargeHeap.poll());
        topSmallSize++;
      } else {
        deleteTop(topSmallHeap);
        topSmallHeap.offer(num);
        topLargeHeap.offer(topSmallHeap.poll());
        topLargeSize++;
      }
    }

    public void deleteNum(int num) {
      if (!topLargeHeap.isEmpty() && num <= topLargeHeap.peek()) {
        waitDelateNum.put(num, waitDelateNum.getOrDefault(num, 0) + 1);
        deleteTop(topLargeHeap);
        topLargeSize--;
      } else if (!topSmallHeap.isEmpty() && num >= topSmallHeap.peek()) {
        waitDelateNum.put(num, waitDelateNum.getOrDefault(num, 0) + 1);
        deleteTop(topSmallHeap);
        topSmallSize--;
      }

      if (topLargeSize > topSmallSize) {
        deleteTop(topLargeHeap);
        topSmallHeap.offer(topLargeHeap.poll());
        topLargeSize--;
        topSmallSize++;
      }
      if (topSmallSize - topLargeSize > 1) {
        deleteTop(topSmallHeap);
        topLargeHeap.offer(topSmallHeap.poll());
        topSmallSize--;
        topLargeSize++;
      }
    }

    public double findMedian() {
      if (Objects.equals(topSmallSize, topLargeSize)) {
        deleteTop(topSmallHeap);
        deleteTop(topLargeHeap);
        return (0.0D + topLargeHeap.peek() + topSmallHeap.peek()) / 2.0;
      } else {
        deleteTop(topSmallHeap);
        return topSmallHeap.peek();
      }
    }

    public int size() {
      return topSmallHeap.size() + topLargeHeap.size();
    }

    private void deleteTop(PriorityQueue<Integer> queue) {
      while (!queue.isEmpty() && waitDelateNum.getOrDefault(queue.peek(), 0) > 0) {
        int deleted = queue.poll();
        waitDelateNum.put(deleted, waitDelateNum.get(deleted) - 1);
      }
    }
  }
  // end::answer[]

  static void main() {
    new _0480_SlidingWindowMedian_3().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
