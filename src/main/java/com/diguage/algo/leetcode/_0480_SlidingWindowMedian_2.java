package com.diguage.algo.leetcode;

import java.util.PriorityQueue;

public class _0480_SlidingWindowMedian_2 {
  // tag::answer[]

  /**
   * 优化前，通过 43 / 44 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-15 22:04:02
   */
  public double[] medianSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> topSmall = new PriorityQueue<>();
    PriorityQueue<Integer> topLarge = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    double[] result = new double[nums.length - k + 1];
    for (int i = 0; i < k - 1; i++) {
      int num = nums[i];
      addNum(topSmall, topLarge, num);
    }
    for (int i = k - 1; i < nums.length; i++) {
      if (i >= k) {
        int delete = nums[i - k];
        if (delete > topLarge.peek()) {
          topSmall.remove(delete);
          if (topLarge.size() - topSmall.size() > 1) {
            topSmall.offer(topLarge.poll());
          }
        } else {
          topLarge.remove(delete);
          if (topLarge.size() < topSmall.size()) {
            topLarge.offer(topSmall.poll());
          }
        }
      }
      addNum(topSmall, topLarge, nums[i]);
      result[i - k + 1] = getMedian(k, topSmall, topLarge);
    }
    return result;
  }

  private static double getMedian(int k, PriorityQueue<Integer> topSmall, PriorityQueue<Integer> topLarge) {
    double median;
    if (k % 2 == 0) {
      median = (0D + topSmall.peek() + topLarge.peek()) / 2.0;
    } else {
      median = topLarge.peek();
    }
    return median;
  }

  private static void addNum(PriorityQueue<Integer> topSmall, PriorityQueue<Integer> topLarge, int num) {
    if (topSmall.size() == topLarge.size()) {
      topSmall.offer(num);
      topLarge.offer(topSmall.poll());
    } else {
      topLarge.offer(num);
      topSmall.offer(topLarge.poll());
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0480_SlidingWindowMedian_2()
      .medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
