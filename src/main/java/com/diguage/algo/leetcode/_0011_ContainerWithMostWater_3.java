package com.diguage.algo.leetcode;

public class _0011_ContainerWithMostWater_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 19:38:05
   */
  public int maxArea(int[] height) {
    int result = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      result = Math.max(result,
        Math.min(height[left], height[right]) * (right - left - 1));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return result;
  }
  // end::answer[]
}
