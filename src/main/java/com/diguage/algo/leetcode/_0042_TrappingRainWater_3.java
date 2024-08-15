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
public class _0042_TrappingRainWater_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-15 19:07:40
   */
  public int trap(int[] height) {
    int result = 0;
    int left = 0, right = height.length - 1;
    int lMax = 0, rMax = 0;
    while (left < right) {
      lMax = Math.max(lMax, height[left]);
      rMax = Math.max(rMax, height[right]);
      if (lMax < rMax) {
        result += lMax - height[left];
        left++;
      } else {
        result += rMax - height[right];
        right--;
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    _0042_TrappingRainWater_3 solution = new _0042_TrappingRainWater_3();
    int r1 = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    System.out.println((r1 == 6) + " : " + r1);
  }
}

