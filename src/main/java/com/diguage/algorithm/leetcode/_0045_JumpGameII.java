package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 45. Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/[Jump Game II - LeetCode]
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * .Example:
 * [source]
 * ----
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * ----
 *
 * *Note:*
 *
 * You can assume that you can always reach the last index.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-10-26 11:29
 */
public class _0045_JumpGameII {
    /**
     * Runtime: 1 ms, faster than 99.98% of Java online submissions for Jump Game II.
     *
     * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Jump Game II.
     */
    public int jump(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int step = 0;
        int currentStepEnd = 0;
        int currentFarthestIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentFarthestIndex = Math.max(currentFarthestIndex, i + nums[i]);
            if (i == currentStepEnd) {
                step++;
                currentStepEnd = currentFarthestIndex;
            }
        }
        return step;
    }

    // TODO: Dynamic Programming

    public static void main(String[] args) {
        _0045_JumpGameII solution = new _0045_JumpGameII();
        int r1 = solution.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println((r1 == 2) + " : " + r1);
    }
}
