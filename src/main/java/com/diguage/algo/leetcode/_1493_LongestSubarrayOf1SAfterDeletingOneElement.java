package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1493_LongestSubarrayOf1SAfterDeletingOneElement {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-31 23:07:47
   */
  public int longestSubarray(int[] nums) {
    int result = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i <= nums.length; i++) {
      if (i == 0) {
        if (nums[i] == 0) {
          queue.offer(i);
        } else {
          queue.offer(-1);
        }
        continue;
      } else if (i == nums.length) {
        queue.offer(nums.length);
      } else if (nums[i] == 0) {
        queue.offer(i);
      }
      while (queue.size() == 3) {
        result = Math.max(result, queue.peekLast() - queue.poll() - 2);
      }
    }
    if (queue.size() == 2) {
      Integer first = queue.poll();
      Integer last = queue.peekLast();
      result = Math.max(result, last - first - (first >= 0 ? 1 : 2));
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _1493_LongestSubarrayOf1SAfterDeletingOneElement()
      .longestSubarray(new int[]{0, 1, 1, 1, 1, 1});
//      .longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
  }
}
