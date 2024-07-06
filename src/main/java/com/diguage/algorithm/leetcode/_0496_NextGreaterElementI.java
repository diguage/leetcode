package com.diguage.algorithm.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-05 22:40:25
 */
public class _0496_NextGreaterElementI {
  // tag::answer[]
  /**
   * 单调栈，参考模板，自己书写
   */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Deque<Integer> stack = new LinkedList<>();
    Map<Integer, Integer> big = new HashMap<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() < nums2[i]) {
        stack.pop();
      }
      int val = stack.isEmpty() ? -1 : stack.peek();
      big.put(nums2[i], val);
      stack.push(nums2[i]);
    }
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      result[i] = big.get(nums1[i]);
    }
    return result;
  }
  // end::answer[]
}
