package com.diguage.algo.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class _0480_SlidingWindowMedian {
  // tag::answer[]

  /**
   * 答案是正确的，超大数组测试时，超时了。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-30 11:45:50
   */
  public double[] medianSlidingWindow(int[] nums, int k) {
    // 如果窗口是奇数，则 topSmall 多一个
    Queue<Integer> topSmall = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    // 使用 Integer.compare，防止两个最小负数相减时溢出
    Queue<Integer> topLarge = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    double[] result = new double[nums.length - k + 1];
    for (int i = 0; i < k; i++) {
      topSmall.add(nums[i]);
    }
    for (int i = 0; i < k / 2; i++) {
      topLarge.add(topSmall.poll());
    }
    // 先相处再相加，防止溢出
    result[0] = k % 2 == 1 ? 1.0 * topSmall.peek()
      : topSmall.peek() / 2.0 + topLarge.peek() / 2.0;
    for (int i = k; i < nums.length; i++) {
      int num = nums[i];
      if (topSmall.peek() <= num) {
        topSmall.add(num);
      } else {
        topLarge.add(num);
      }

      int delNum = nums[i - k];
      if (topSmall.peek() <= delNum) {
        topSmall.remove(delNum);
      } else {
        topLarge.remove(delNum);
      }
      // 添加，删除，再平衡双堆，这样才能保证堆的平衡性
      // topSmall 应该始终大于等于 topLarge
      while (topLarge.size() > topSmall.size()) {
        topSmall.add(topLarge.poll());
      }
      // topSmall 与 topLarge 的差值不能大于 1
      while (topSmall.size() - topLarge.size() > 1) {
        topLarge.add(topSmall.poll());
      }

      result[i - k + 1] = k % 2 == 1 ? 1.0 * topSmall.peek()
        : topSmall.peek() / 2.0 + topLarge.peek() / 2.0;
    }
    return result;
  }
  // end::answer[]
}
