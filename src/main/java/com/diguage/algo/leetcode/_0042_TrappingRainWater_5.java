package com.diguage.algo.leetcode;

public class _0042_TrappingRainWater_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-24 23:12:58
   */
  public int trap(int[] height) {
    int lh = 0, rh = 0;
    int left = 0, right = height.length - 1;
    int result = 0;
    while (left < right) {
      int heigh = Math.min(lh, rh);
      lh = Math.max(lh, height[left]);
      rh = Math.max(rh, height[right]);
      if (height[left] < height[right]) {
        if (height[left] < heigh) {
          result += (heigh - height[left]);
        }
        left++;
      } else {
        if (height[right] < heigh) {
          result += (heigh - height[right]);
        }
        right--;
      }
    }
    return result;
  }
  // end::answer[]
}
