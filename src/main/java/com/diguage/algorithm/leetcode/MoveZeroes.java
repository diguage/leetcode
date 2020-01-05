package com.diguage.algorithm.leetcode;

import java.util.Arrays;

/**
 * = 283. Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/[Move Zeroes - LeetCode]
 *
 * Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.
 *
 * .Example:
 * [source]
 * ----
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * ----
 *
 * *Note:*
 *
 * . You must do this *in-place* without making a copy of the array.
 * . Minimize the total number of operations.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-05 22:26
 */
public class MoveZeroes {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     *
     * Memory Usage: 38 MB, less than 93.01% of Java online submissions for Move Zeroes.
     */
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            nums[i - count] = nums[i];
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] a1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(a1);
        int[] r1 = {1, 3, 12, 0, 0};
        System.out.println(Arrays.equals(a1, r1) + " : " + Arrays.toString(a1));
    }
}
