package com.diguage.algo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * = 42. Trapping Rain Water
 * 
 * https://leetcode.com/problems/trapping-rain-water/[Trapping Rain Water - LeetCode]
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * image::https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png[title="The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!"]
 * 
 * .Example:
 * [source]
 * ----
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * ----
 */
public class _0042_TrappingRainWater_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-31 17:27:46
   */
  public int trap(int[] height) {
    int result = 0;
    Deque<Integer> stack = new LinkedList<>();
    stack.push(0);
    for (int r = 1; r < height.length; r++) {
      // 单调递减，则将小的元素都出栈
      while (!stack.isEmpty() && height[stack.peek()] < height[r]) {
        // 递减栈，栈顶最小。与下一个元素比，栈顶小；
        // 上面判断条件，栈顶与当前位置元素比，也是栈顶小
        int mid = stack.pop();
        if (!stack.isEmpty()) {
          int l = stack.peek();
          // 高h 取两边最小的一个。
          // l 是现栈顶元素大，mid 是前栈顶元素最小，当前元素比 mid 大，
          // 所以，形成了一个凹槽，可以接水
          int h = Math.min(height[l], height[r]) - height[mid];
          int w = r - l - 1;
          int area = h * w;
          result += area;
        }
      }
      stack.push(r);
    }
    return result;
  }
  // end::answer[]


  public static void main(String[] args) {
    _0042_TrappingRainWater_2 solution = new _0042_TrappingRainWater_2();
    int r1 = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    System.out.println((r1 == 6) + " : " + r1);
  }
}

