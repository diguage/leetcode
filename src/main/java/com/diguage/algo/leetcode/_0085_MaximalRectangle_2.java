package com.diguage.algo.leetcode;

public class _0085_MaximalRectangle_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-09 22:14:49
   */
  public int maximalRectangle(char[][] matrix) {
    int n = matrix[0].length;
    int[] heights = new int[n + 1];
    int result = 0;
    for (char[] chars : matrix) {
      // 计算底边为 row 的柱子高度
      for (int j = 0; j < n; j++) {
        if (chars[j] == '0') {
          heights[j] = 0;// 柱子高度为 0
        } else {
          heights[j]++;// 柱子高度加一
        }
      }
      // 从上往下长，逐行长高，逐行计算
      result = Math.max(result, largestRectangleArea(heights));
    }
    return result;
  }

  private int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] stack = new int[n];
    int top = -1;
    stack[++top] = -1;
    int result = 0;
    for (int right = 0; right < n; right++) {
      int h = heights[right];
      while (top > 0 && heights[stack[top]] >= h) {
        int i = stack[top--];
        int left = stack[top];
        result = Math.max(result, heights[i] * (right - left - 1));
      }
      stack[++top] = right;
    }
    return result;
  }
  // end::answer[]
}
