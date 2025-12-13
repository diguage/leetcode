package com.diguage.algo.leetcode;

import java.util.*;

public class _0480_SlidingWindowMedian_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-13 22:22:04
   */
  public double[] medianSlidingWindow(int[] nums, int k) {
    List<Double> result = new ArrayList<>();
    _0480_SlidingWindowMedian_3.MedianFinder finder = new _0480_SlidingWindowMedian_3.MedianFinder();
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

//  private static class DualHeap {
//    private Map<Integer, Integer> counter;
//    private PriorityQueue<Integer> topSmallHeap;
//    private PriorityQueue<Integer> topLargeHeap;
//    private int topSmallHeapSize;
//    private int topLargeHeapSize;
//
//    public DualHeap(int capacity) {
//      counter = new HashMap<>();
//      topSmallHeap = new PriorityQueue<>();
//      topSmallHeapSize = 0;
//      topLargeHeap = new PriorityQueue<>((a, b) -> b - a);
//      topLargeHeapSize = 0;
//    }
//
//    public void offer(int num) {
//      if (Objects.equals(topSmallHeapSize, topLargeHeapSize)) {
//        topLargeHeap.offer(num);
//        pollRemovedTop(topLargeHeap);
//        Integer top = topLargeHeap.poll();
//        topSmallHeap.offer(top);
//        topSmallHeapSize++;
//      } else {
//        topSmallHeap.offer(num);
//        pollRemovedTop(topSmallHeap);
//        Integer top = topSmallHeap.poll();
//        topLargeHeap.offer(top);
//        topLargeHeapSize++;
//      }
//    }
//
//    public void deleteNum(int num) {
//      if (!topLargeHeap.isEmpty() && num <= topLargeHeap.peek()) {
//        counter.put(num, counter.getOrDefault(num, 0) + 1);
//        pollRemovedTop(topLargeHeap);
//        topLargeHeapSize--;
//      } else if (!topSmallHeap.isEmpty() && num >= topSmallHeap.peek()) {
//        counter.put(num, counter.getOrDefault(num, 0) + 1);
//        pollRemovedTop(topSmallHeap);
//        topSmallHeapSize--;
//      }
//
//      if (topLargeHeapSize > topSmallHeapSize) {
//        pollRemovedTop(topLargeHeap);
//        topSmallHeap.offer(topLargeHeap.poll());
//        topLargeHeapSize--;
//        topSmallHeapSize++;
//      }
//      if (topSmallHeapSize - topLargeHeapSize > 1) {
//        pollRemovedTop(topSmallHeap);
//        topLargeHeap.offer(topSmallHeap.poll());
//        topSmallHeapSize--;
//        topLargeHeapSize++;
//      }
//    }
//
//    public double findMedian() {
//      if (Objects.equals(topSmallHeapSize, topLargeHeapSize)) {
//        pollRemovedTop(topSmallHeap);
//        pollRemovedTop(topLargeHeap);
//        return (0.0 + topSmallHeap.peek() + topLargeHeap.peek()) / 2;
//      } else {
//        pollRemovedTop(topSmallHeap);
//        return topSmallHeap.peek();
//      }
//    }
//
//    public int size() {
//      return topSmallHeapSize + topLargeHeapSize;
//    }
//
//    private void pollRemovedTop(PriorityQueue<Integer> heap) {
//      if (heap.isEmpty()) {
//        return;
//      }
//      Integer top = heap.peek();
//      while (!heap.isEmpty() && counter.containsKey(top)) {
//        heap.poll();
//        Integer cnt = counter.get(top);
//        if (cnt > 1) {
//          counter.put(top, cnt - 1);
//        } else {
//          counter.remove(top);
//        }
//        top = heap.peek();
//      }
//    }
//  }

//  private static class DualHeap {
//    private Deque<Integer> heap;
//    private int capacity;
//    private Map<Integer, Integer> counter;
//    private PriorityQueue<Integer> topSmallHeap;
//    private PriorityQueue<Integer> topLargeHeap;
//    private int topSmallHeapSize;
//    private int topLargeHeapSize;
//
//    public DualHeap(int capacity) {
//      this.capacity = capacity;
//      heap = new ArrayDeque<>();
//      counter = new HashMap<>();
//      topSmallHeap = new PriorityQueue<>();
//      topSmallHeapSize = 0;
//      topLargeHeap = new PriorityQueue<>((a, b) -> b - a);
//      topLargeHeapSize = 0;
//    }
//
//    public void offer(int val) {
//      heap.addLast(val);
//      if (heap.size() > capacity) {
//        Integer removed = heap.removeFirst();
//        counter.put(removed, counter.getOrDefault(removed, 0) + 1);
//        int top = getTop(topLargeHeap);
//        if (removed <= top) {
//          topLargeHeapSize--;
//        } else {
//          topSmallHeapSize--;
//        }
//      }
//
//      while (topSmallHeapSize > topLargeHeapSize + 1) {
//        getTop(topSmallHeap);
//        int top = topSmallHeap.poll();
//        topLargeHeap.offer(top);
//        topLargeHeapSize++;
//        topSmallHeapSize--;
//      }
//
//      while (topLargeHeapSize > topSmallHeapSize) {
//        getTop(topLargeHeap);
//        Integer top = topLargeHeap.poll();
//        topSmallHeap.offer(top);
//        topSmallHeapSize++;
//        topLargeHeapSize--;
//      }
//
//      if (topSmallHeapSize == topLargeHeapSize) {
//        topLargeHeap.offer(val);
//        getTop(topLargeHeap);
//        Integer top = topLargeHeap.poll();
//        topSmallHeap.offer(top);
//        topSmallHeapSize++;
//      } else {
//        topSmallHeap.offer(val);
//        getTop(topSmallHeap);
//        int top = topSmallHeap.poll();
//        topLargeHeap.offer(top);
//        topLargeHeapSize++;
//      }
//    }
//
//    public double findMedian() {
//      if (topSmallHeapSize == topLargeHeapSize) {
//        int small = getTop(topSmallHeap);
//        int large = getTop(topLargeHeap);
//        return (0.0 + small + large) / 2;
//      } else {
//        return getTop(topSmallHeap);
//      }
//    }
//
//    public int size() {
//      return heap.size();
//    }
//
//    private int getTop(PriorityQueue<Integer> heap) {
//      int top = heap.peek();
//      while (counter.containsKey(top)) {
//        heap.poll();
//        Integer cnt = counter.get(top);
//        if (cnt > 1) {
//          counter.put(top, cnt - 1);
//        } else {
//          counter.remove(top);
//        }
//        top = heap.peek();
//      }
//      return top;
//    }
//  }
  // end::answer[]

  static void main() {
    new _0480_SlidingWindowMedian_4()
      .medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
