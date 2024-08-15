package com.diguage.algo.leetcode;

/**
 * = 11. Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/[Container With Most Water - LeetCode]
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-07-13
 */
public class _0011_ContainerWithMostWater_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-15 19:54:27
   */
  public static int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int result = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        result = Math.max(result, height[left] * (right - left));
        left++;
      } else {
        result = Math.max(result, height[right] * (right - left));
        right--;
      }
    }
    return result;
  }
  // end::answer[]
}
