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
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-07-13
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int length = right - left;
            boolean greater = height[left] < height[right];
            int high = greater ? height[left] : height[right];
            int area = length * high;
            if (area > result) {
                result = area;
            }
            if (greater) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{3, 8, 4, 7, 5, 9, 1, 2, 6};
        System.out.println(maxArea(height));
    }
}
