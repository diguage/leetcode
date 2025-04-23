package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0084_LargestRectangleInHistogram {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-23 20:07:47
   */
  public int largestRectangleArea(int[] heights) {
    int length = heights.length;
    if (length == 1) {
      return heights[0];
    }
    int[] newHeights = new int[length + 2];
    // 两端是两个哨兵
    newHeights[0] = 0;
    newHeights[length + 1] = 0;
    System.arraycopy(heights, 0, newHeights, 1, length);
    heights = newHeights;
    int result = 0;
    length += 2;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0); // 哨兵，可以省去栈的非空判断
    for (int i = 1; i < length; i++) {
      // 单调递增栈
      // 当需要出栈的时候，就是当前元素小于栈顶元素。
      // 这样，弹出栈顶元素，以弹出的栈顶元素作为高，
      // 由于是单调递增栈，现在栈顶元素是小于已弹出的栈顶元素。
      // 所以，栈顶元素和当前坐标就是以弹出的栈顶元素的左右两个更低的柱子
      // 那么，就弹出的栈顶元素作为高，当前坐标-栈顶元素（存的坐标）-1作为宽
      // 就可以计算相关柱子组成的面积了。
      while (heights[i] < heights[stack.peekLast()]) {
        int currHeight = heights[stack.pollLast()];
        int currWidth = i - stack.peekLast() - 1;
        result = Math.max(result, currHeight * currWidth);
      }
      stack.addLast(i);
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0084_LargestRectangleInHistogram()
      .largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
  }
}
