package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 55. Jump Game
 *
 * https://leetcode.com/problems/jump-game/[Jump Game - LeetCode]
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-23 12:25
 */
public class JumpGame {
    /**
     * Runtime: 1 ms, faster than 99.35% of Java online submissions for Jump Game.
     *
     * Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Jump Game.
     */
    public boolean canJump(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return true;
        }
        int lenght = nums.length;
        int tail = lenght - 1;
        for (int i = tail - 1; i >= 0; i--) {
            if (nums[i] >= tail - i || nums[i] >= lenght - 1 - i) {
                tail = i;
            }
        }

        return tail <= 0;
    }

    // TODO: Backtracking
    // TODO: Dynamic Programming Top-down
    // TODO: Dynamic Programming Bottom-up

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        boolean r1 = solution.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(r1);

        boolean r2 = solution.canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(r2);

        boolean r3 = solution.canJump(new int[]{2, 0});
        System.out.println(r3);

        boolean r4 = solution.canJump(new int[]{2, 5, 0, 0});
        System.out.println(r4);
    }
}
