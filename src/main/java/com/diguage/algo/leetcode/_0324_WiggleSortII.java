package com.diguage.algo.leetcode;

import java.util.Arrays;

/**
 * = 324. Wiggle Sort II
 *
 * Given an unsorted array nums, reorder it such that `nums[0] < nums[1] > nums[2] < nums[3]....`
 *
 * .Example 1:
 * [source]
 * ----
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * ----
 *
 * *Note:*
 *
 * You may assume all input has valid answer.
 *
 * *Follow Up:*
 *
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-26 23:29
 */
public class _0324_WiggleSortII {
  // tag::answer[]

    /**
     * Runtime: 3 ms, faster than 99.88% of Java online submissions for Wiggle Sort II.
     *
     * Memory Usage: 44.2 MB, less than 10.00% of Java online submissions for Wiggle Sort II.
     *
     * Copy from https://leetcode-cn.com/problems/wiggle-sort-ii/solution/javaxiang-xi-ti-jie-shuo-ming-by-heator/[Java详细题解说明 - 摆动排序 II - 力扣（LeetCode）]
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] smaller = new int[length % 2 == 0 ? length / 2 : (length / 2 + 1)];
        int[] bigger = new int[length / 2];
        System.arraycopy(nums, 0, smaller, 0, smaller.length);
        System.arraycopy(nums, smaller.length, bigger, 0, bigger.length);
        int i = 0;
        for (; i < length / 2; i++) {
            int si = smaller.length - 1 - i;
            nums[2 * i] = smaller[si];
            int bi = length / 2 - 1 - i;
            nums[2 * i + 1] = bigger[bi];
        }
        if (length % 2 != 0) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
        }
    }


  // end::answer[]


    public static void main(String[] args) {
        _0324_WiggleSortII solution = new _0324_WiggleSortII();
        int[] n1 = {1, 5, 1, 1, 6, 4};
        solution.wiggleSort(n1);
        System.out.println(Arrays.toString(n1));

        int[] n2 = {1, 3, 2, 2, 3, 1};
        solution.wiggleSort(n2);
        System.out.println(Arrays.toString(n2));
    }
}
