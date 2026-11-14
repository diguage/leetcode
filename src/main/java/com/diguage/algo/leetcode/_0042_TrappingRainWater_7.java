package com.diguage.algo.leetcode;

public class _0042_TrappingRainWater_7 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-14 23:18:41
   */
  public int trap(int[] height) {
    int result = 0;
    int left = 0, right = height.length - 1;
    int maxLeft = height[left], maxRight = height[right];
    while (left <= right) {
      maxLeft = Math.max(maxLeft, height[left]);
      maxRight = Math.max(maxRight, height[right]);
      int min = Math.min(maxLeft, maxRight);
      if (height[left] < height[right]) {
        result += min > height[left] ? min - height[left] : 0;
        left++;
      } else {
        result += min > height[right] ? min - height[right] : 0;
        right--;
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0042_TrappingRainWater_7().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
  }
}
