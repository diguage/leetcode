package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0084_LargestRectangleInHistogram_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-14 21:21:27
   */
  public int largestRectangleArea(int[] heights) {
    int[] temp = new int[heights.length + 2];
    // 两个哨兵，推动把整个数组处理完
    temp[0] = 0;
    temp[temp.length - 1] = 0;
    System.arraycopy(heights, 0, temp, 1, heights.length);
    heights = temp;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);
    int result = 0;
    for (int i = 1; i < heights.length; i++) {
      while (heights[i] < heights[stack.peek()]) {
        // 弹出的栈顶元素最高
        int height = heights[stack.pop()];
        // 两边(当前栈顶元素，当前遍历元素)都是比它低的
        // 左边：已弹出的栈顶元素肯定都是比当前栈顶元素高；如果有更低的，当前元素早就被弹出了
        // 右边：当前遍历元素肯定比最近弹出的栈顶元素低。高的话，直接压栈了。
        int width = i - stack.peek() - 1;
        result = Math.max(result, height * width);
      }
      stack.push(i);
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0084_LargestRectangleInHistogram_2()
      .largestRectangleArea(new int[]{2, 1, 2});
  }
}
