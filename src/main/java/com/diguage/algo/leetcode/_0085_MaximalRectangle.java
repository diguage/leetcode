package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0085_MaximalRectangle {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-25 20:59:45
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int[] heights = new int[matrix[0].length];
    int result = 0;
    for (int row = 0; row < matrix.length; row++) {
      // 计算出每一行的高度
      for (int column = 0; column < matrix[row].length; column++) {
        if (matrix[row][column] == '1') {
          heights[column] += 1;
        } else {
          heights[column] = 0;
        }
      }
      // 利用每一行的高度，去计算可以组成的最大矩阵面积
      result = Math.max(result, largestRectangleArea(heights));
    }
    return result;
  }

  private int largestRectangleArea(int[] heights) {
    int length = heights.length;
    if (length == 1) {
      return heights[0];
    }
    int[] newHeights = new int[length + 2];
    // 两端两个哨兵
    newHeights[0] = 0;
    newHeights[length + 1] = 0;
    System.arraycopy(heights, 0, newHeights, 1, length);
    heights = newHeights;
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(heights[0]);
    int result = 0;
    for (int i = 1; i < newHeights.length; i++) {
      while (heights[i] < heights[stack.peek()]) {
        Integer left = stack.pop();
        // 以弹出的栈顶元素为高，因为有可能一柱擎天就是最大的面积
        // 另外，弹出一个元素后，如果当前高度还是比栈顶元素低，
        //      那么下次再弹出时，就会一个更低的高度去计算从栈顶元素到 i-1 的矩阵了
        int hight = heights[left];
        // 因为 heights[i] 已经变低了，所以，得从 i-1 开始想前算
        int width = (i - 1) - stack.peek();
        result = Math.max(result, hight * width);
      }
      stack.push(i);
    }
    return result;
  }
  // end::answer[]
}
