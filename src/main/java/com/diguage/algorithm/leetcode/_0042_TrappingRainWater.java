package com.diguage.algorithm.leetcode;

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
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-07-26 08:49
 */
public class _0042_TrappingRainWater {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Trapping Rain Water.
     * Memory Usage: 38.3 MB, less than 91.10% of Java online submissions for Trapping Rain Water.
     *
     * Copy from: https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/[详细通俗的思路分析，多解法 - 接雨水 - 力扣（LeetCode）]
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += (leftMax - height[left]);
                }
                ++left;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    result += (rightMax - height[right]);
                }
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _0042_TrappingRainWater solution = new _0042_TrappingRainWater();
        int r1 = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println((r1 == 6) + " : " + r1);
    }
}

