package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0042_TrappingRainWater_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-20 18:38:35
   */
  public int trap(int[] height) {
    Deque<Integer> stack = new ArrayDeque<>(height.length);
    int result = 0;
    for (int right = 0; right < height.length; right++) {
      while (!stack.isEmpty() && height[stack.peek()] < height[right]) {
        int mid = stack.poll();
        if (stack.isEmpty()) {
          break;
        }
        Integer left = stack.peek();
        int h = Math.min(height[left], height[right]) - height[mid];
        int w = right - left - 1;
        result += h * w;
      }
      stack.push(right);
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0042_TrappingRainWater_4().trap(new int[]{4, 2, 0, 3, 2, 5});
  }
}
