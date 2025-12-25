package com.diguage.algo.leetcode;

public class _0042_TrappingRainWater_6 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-25 20:50:09
   */
  public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int maxLeft = height[left], maxRight = height[right];
    int result = 0;
    while (left < right) {
      maxLeft = Math.max(maxLeft, height[left]);
      maxRight = Math.max(maxRight, height[right]);
      // 直接比较左右两端的最大值，这样处理更省事
      if (maxLeft < maxRight) {
        result += maxLeft - height[left];
        left++;
      } else {
        result += maxRight - height[right];
        right--;
      }
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0042_TrappingRainWater_6()
      .trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
  }
}
