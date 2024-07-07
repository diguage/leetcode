package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 81. Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/[Search in Rotated Sorted Array II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-04 22:13
 */
public class _0081_SearchInRotatedSortedArrayII {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
     * Memory Usage: 38.6 MB, less than 88.73% of Java online submissions for Search in Rotated Sorted Array II.
     *
     * Copy from: https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/[搜索旋转排序数组 II - 搜索旋转排序数组 II - 力扣（LeetCode）]
     */
    public boolean search(int[] nums, int target) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0081_SearchInRotatedSortedArrayII solution = new _0081_SearchInRotatedSortedArrayII();

        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));

        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}
