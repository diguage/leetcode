package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 239. Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/[Sliding Window Maximum - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-06 16:20:24
 */
public class _0239_SlidingWindowMaximum_2 {
  // tag::answer[]
  /**
   * 参考 https://leetcode.cn/problems/sliding-window-maximum/solutions/543426/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/[239. 滑动窗口最大值 - 官方题解^]
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-06 16:20:24
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    int len = nums.length;
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }
    int[] result = new int[len - k + 1];
    result[0] = nums[deque.peekFirst()];
    for (int i = k; i < len; i++) {
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      while (deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      result[i - k + 1] = nums[deque.peekFirst()];
    }
    return result;
  }

  // end::answer[]


  public static void main(String[] args) {
    new _0239_SlidingWindowMaximum_2()
      .maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
