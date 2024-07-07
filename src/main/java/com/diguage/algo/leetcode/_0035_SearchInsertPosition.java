package com.diguage.algo.leetcode;

/**
 * = 35. Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/[Search Insert Position - LeetCode]
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [1,3,5,6], 5
 * Output: 2
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [1,3,5,6], 2
 * Output: 1
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: [1,3,5,6], 7
 * Output: 4
 * ----
 *
 * .Example 4:
 * [source]
 * ----
 * Input: [1,3,5,6], 0
 * Output: 0
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-09-16 21:32
 */
public class _0035_SearchInsertPosition {
  // tag::answer[]
    public static int searchInsert(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        if (target <= nums[0]) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midNum = nums[mid];
            if (midNum >= target
                && ((mid - 1) >= 0) && nums[mid - 1] < target) {
                result = mid;
                break;
            }
            if ((mid - 1 >= 0) && target <= nums[mid - 1]) {
                high = mid - 1;
            }
            if (midNum < target) {
                low = mid + 1;
            }
        }

        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}
