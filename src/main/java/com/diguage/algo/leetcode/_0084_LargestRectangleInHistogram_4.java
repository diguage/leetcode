package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0084_LargestRectangleInHistogram_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-27 23:17:25
   */
  public int largestRectangleArea(int[] heights) {
    int result = 0;
    int[] temp = new int[heights.length + 2];
    System.arraycopy(heights, 0, temp, 1, heights.length);
    heights = temp;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        Integer right = stack.pop();
        int width = i - stack.peek() - 1;
        result = Math.max(result, width * heights[right]);
      }
      stack.push(i);
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0084_LargestRectangleInHistogram_4()
      .largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
  }
}
