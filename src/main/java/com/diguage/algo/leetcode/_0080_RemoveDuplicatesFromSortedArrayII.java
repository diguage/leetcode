package com.diguage.algo.leetcode;

/**
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-04 20:57
 */
public class _0080_RemoveDuplicatesFromSortedArrayII {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
     * Memory Usage: 41.7 MB, less than 5.26% of Java online submissions for Remove Duplicates from Sorted Array II.
     *
     * Copy from: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-i-7/[删除排序数组中的重复项 II - 删除排序数组中的重复项 II - 力扣（LeetCode）]
     */
    public int removeDuplicates(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0080_RemoveDuplicatesFromSortedArrayII solution = new _0080_RemoveDuplicatesFromSortedArrayII();
        int[] n1 = {1, 1, 1, 2, 2, 3};
        int r1 = solution.removeDuplicates(n1);
        System.out.println((r1 == 5) + " : " + r1);

        int[] n2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int r2 = solution.removeDuplicates(n2);
        System.out.println((r2 == 7) + " : " + r2);
    }
}
