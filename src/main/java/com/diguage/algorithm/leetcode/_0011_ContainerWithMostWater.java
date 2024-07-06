package com.diguage.algorithm.leetcode;

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
public class _0011_ContainerWithMostWater {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2018-07-13
   */
  public static int maxArea(int[] height) {
    int result = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      result = Math.max(result, area);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return result;
  }

  // end::answer[]


  public static void main(String[] args) {
    int[] height = new int[]{3, 8, 4, 7, 5, 9, 1, 2, 6};
    System.out.println(maxArea(height));
  }
}
