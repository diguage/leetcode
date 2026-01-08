package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0084_LargestRectangleInHistogram_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-08 20:25:59
   */
  public int largestRectangleArea(int[] heights) {
    int length = heights.length;
    int[] temp = new int[length + 2];
    // 首尾默认是0，可以作为哨兵，推进计算完成。
    System.arraycopy(heights, 0, temp, 1, length);
    heights = temp;
    Deque<Integer> stack = new ArrayDeque<>(length);
    int result = 0;
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        Integer right = stack.pop();
        int width = i - stack.peek() -1;
        result = Math.max(result, width * heights[right]);
      }
      stack.push(i);
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0084_LargestRectangleInHistogram_3()
      .largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
  }
}
