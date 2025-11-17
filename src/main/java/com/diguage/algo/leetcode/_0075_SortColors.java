package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 75. Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/[Sort Colors - LeetCode]
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * .Example:
 * [source]
 * ----
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * ----
 *
 * *Follow up:*
 *
 * * A rather straight forward solution is a two-pass algorithm using counting sort.
 * +
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * +
 * * Could you come up with a one-pass algorithm using only constant space?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-10-29 01:01
 */
public class _0075_SortColors {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
     *
     * Memory Usage: 35.2 MB, less than 99.21% of Java online submissions for Sort Colors.
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2019-10-29 20:26
     */
    public void sortColors(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return;
        }
        int current = 0;
        int head = 0;
        int tail = nums.length - 1;
        while (current <= tail) {
            if (nums[current] == 0) {
                swap(nums, current, head);
                head++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, tail);
                tail--;
                // 这了不需要 current++，就是把这个数字重新排队一遍！
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0075_SortColors solution = new _0075_SortColors();
        int[] array = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(array));
        solution.sortColors(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {1, 2, 0, 0};
        System.out.println(Arrays.toString(array2));
        solution.sortColors(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {1, 2, 2, 2, 2, 0, 0, 0, 1, 1};
        System.out.println(Arrays.toString(array3));
        solution.sortColors(array3);
        System.out.println(Arrays.toString(array3));
    }
}
