package com.diguage.algo.leetcode;

public class _0011_ContainerWithMostWater_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-20 18:13:51
   */
  public int maxArea(int[] height) {
    int result = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      int hi = Math.min(height[left], height[right]);
      result = Math.max(result, hi * (right - left));
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
