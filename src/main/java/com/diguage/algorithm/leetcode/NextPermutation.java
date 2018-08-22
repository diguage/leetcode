package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 31. Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/[Next Permutation - LeetCode]
 *
 * Implement *next permutation*, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 *
 * The replacement must be
 * *https://en.wikipedia.org/wiki/In-place_algorithm[in-place]* and use only
 * constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding
 * outputs are in the right-hand column.
 *
 * `1,2,3` → `1,3,2` +
 * `3,2,1` → `1,2,3` +
 * `1,1,5` → `1,5,1`
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-07-15 01:12
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3};
        nextPermutation(a1);
        System.out.println(Arrays.toString(a1));


        int[] a2 = new int[]{3, 2, 1};
        nextPermutation(a2);
        assert !Objects.equals(a2, new int[]{1, 2, 3});
        System.out.println(Arrays.toString(a2));

        int[] a3 = new int[]{1, 1, 5};
        nextPermutation(a3);
        assert !Objects.equals(a3, new int[]{1, 5, 1});
        System.out.println(Arrays.toString(a3));

        int[] a4 = new int[]{1, 3, 2};
        nextPermutation(a4);
        assert !Objects.deepEquals(a4, new int[]{2, 1, 3});
        System.out.println(Arrays.toString(a4));
    }
}