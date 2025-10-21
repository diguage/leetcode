package com.diguage.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class _0239_SlidingWindowMaximum_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-21 21:11:33
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    List<Integer> stack = new LinkedList<>();
    int[] result = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      while (!stack.isEmpty() && nums[stack.getLast()] < nums[i]) {
        stack.removeLast();
      }
      stack.addLast(i);
      if (i < k - 1) {
        continue;
      }
      result[i - k + 1] = nums[stack.getFirst()];
      if (stack.getFirst() <= i - k + 1) {
        stack.removeFirst();
      }
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0239_SlidingWindowMaximum_4()
      .maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
