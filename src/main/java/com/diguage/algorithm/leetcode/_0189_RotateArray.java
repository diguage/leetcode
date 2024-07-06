package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 189. Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * ----
 *
 * *Note:*
 *
 * * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * * Could you do it in-place with O(1) extra space?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-05 13:05
 */
public class _0189_RotateArray {
  // tag::answer[]

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
     *
     * Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Rotate Array.
     *
     * Copy from: https://leetcode.com/problems/rotate-array/solution/[Rotate Array solution - LeetCode]
     */
    public void rotate(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
     * <p>
     * Memory Usage: 38 MB, less than 85.58% of Java online submissions for Rotate Array.
     */
    public void rotateExtraArray(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0 ||  k % nums.length == 0) {
            return;
        }
        k %= nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[k - i - 1] = nums[nums.length - i - 1];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

  // end::answer[]


    public static void main(String[] args) {
        _0189_RotateArray solution = new _0189_RotateArray();
        int[] a1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        solution.rotate(a1, k1);
        int[] r1 = {5, 6, 7, 1, 2, 3, 4};
        System.out.println(Arrays.equals(a1, r1) + " : " + Arrays.toString(a1));

        int[] a2 = {-1, -100, 3, 99};
        int k2 = 10;
        solution.rotate(a2, k2);
        int[] r2 = {3, 99, -1, -100};
        System.out.println(Arrays.equals(a2, r2) + " : " + Arrays.toString(a2));

        int[] a3 = {-1};
        int k3 = 2;
        solution.rotate(a3, k3);
        int[] r3 = {-1};
        System.out.println(Arrays.equals(a3, r3) + " : " + Arrays.toString(a3));

        int[] a4 = {1, 2};
        int k4 = 1;
        solution.rotate(a4, k4);
        int[] r4 = {2,1};
        System.out.println(Arrays.equals(a4, r4) + " : " + Arrays.toString(a4));
    }
}
