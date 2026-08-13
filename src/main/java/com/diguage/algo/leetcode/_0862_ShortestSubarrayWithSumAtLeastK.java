package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0862_ShortestSubarrayWithSumAtLeastK {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-13 21:00:28
   */
  public int shortestSubarray(int[] nums, int k) {
    int n = nums.length;
    int[] presum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      presum[i + 1] = presum[i] + nums[i];
    }
    int result = n + 1;
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i <= n; i++) {
      int sum = presum[i];
      while (!queue.isEmpty() && sum - presum[queue.peekFirst()] >= k) {
        result = Math.min(result, i - queue.pollFirst());
      }
      while (!queue.isEmpty() && presum[queue.peekLast()] >= sum) {
        queue.pollLast();
      }
      queue.addLast(i);
    }
    return result > n ? -1 : result;
  }
  // end::answer[]
  static void main() {
    new _0862_ShortestSubarrayWithSumAtLeastK()
//      .shortestSubarray(new int[]{0, 0, 69, 56, -34}, 91);
      .shortestSubarray(new int[]{2, -1, 2}, 3);
  }
}
