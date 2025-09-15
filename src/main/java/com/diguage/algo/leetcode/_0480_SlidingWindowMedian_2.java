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
    int index = 0;
    while (index < nums.length) {
      int num = nums[index];
      if (topLarge.isEmpty() || topLarge.peek() >= num) {
        topLarge.add(num);
      } else {
        topSmall.add(num);
      }

      if (k <= index) {
        int delete = nums[index - k];
        if (delete > topLarge.peek()) {
          topSmall.remove(delete);
        } else {
          topLarge.remove(delete);
        }
      }

      while (topSmall.size() > topLarge.size()) {
        topLarge.offer(topSmall.poll());
      }

      while (topLarge.size() - topSmall.size() > 1) {
        topSmall.offer(topLarge.poll());
      }

      if (topSmall.size() + topLarge.size() == k) {
        result[index - k + 1] = getMedian(k, topSmall, topLarge);
      }
      index++;
    }
    return result;
  }

  private static double getMedian(int k, PriorityQueue<Integer> topSmall, PriorityQueue<Integer> topLarge) {
    if ((k & 1) == 1) {
      return topLarge.peek();
    }
    return (0D + topSmall.peek() + topLarge.peek()) / 2.0;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0480_SlidingWindowMedian_2()
      .medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
