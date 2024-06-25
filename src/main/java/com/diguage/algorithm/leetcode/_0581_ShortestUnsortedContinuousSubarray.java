package com.diguage.algorithm.leetcode;

/**
 * = 581. Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/[Shortest Unsorted Continuous Subarray - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-30 21:44
 */
public class _0581_ShortestUnsortedContinuousSubarray {

    /**
     * Runtime: 4 ms, faster than 60.88% of Java online submissions for Shortest Unsorted Continuous Subarray.
     * Memory Usage: 51.8 MB, less than 7.69% of Java online submissions for Shortest Unsorted Continuous Subarray.
     */
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int left, right;
        for (left = 0; left < nums.length; left++) {
            if (min < nums[left]) {
                break;
            }
        }
        for (right = nums.length - 1; right >= 0; right--) {
            if (max > nums[right]) {
                break;
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        _0581_ShortestUnsortedContinuousSubarray solution = new _0581_ShortestUnsortedContinuousSubarray();
        int[] n1 = {2, 6, 4, 8, 10, 9, 15};
        int r1 = solution.findUnsortedSubarray(n1);
        System.out.println((r1 == 5) + " : " + r1);
    }
}
