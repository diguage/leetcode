package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 16. 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/[3Sum Closest - LeetCode]
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 *
 * .Example:
 * [source]
 * ----
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-07-15 00:55
 */
public class _0016_3SumClosest {
  // tag::answer[]
    /**
     * Runtime: 4 ms, faster than 96.20% of Java online submissions for 3Sum Closest.
     *
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for 3Sum Closest.
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2018-07-15 00:55
     */
    public int threeSumClosest(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return target;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int result = 0;
        int difference = Integer.MAX_VALUE;
        for (int head = 0; head < length; head++) {
            int midd = head + 1;
            int tail = length - 1;
            while (midd < tail) {
                int sum = nums[head] + nums[midd] + nums[tail];
                if (sum > target) {
                    while (midd < tail && nums[tail - 1] == nums[tail]) {
                        tail--;
                    }
                    tail--;
                } else if (sum < target) {
                    while (midd < tail && nums[midd] == nums[midd + 1]) {
                        midd++;
                    }
                    midd++;
                } else {
                    return target;
                }
                int tempDiff = Math.abs(sum - target);
                if (tempDiff < difference) {
                    result = sum;
                    difference = tempDiff;
                }
            }
        }

        return result;
    }


    /**
     * Runtime: 73 ms, faster than 7.18% of Java online submissions for 3Sum Closest.
     *
     * Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for 3Sum Closest.
     */
    public int threeSumClosestO3(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return target;
        }
        int length = nums.length;
        if (length <= 3) {
            int result = 0;
            for (int i = 0; i < length; i++) {
                result += nums[i];
            }
            return result;
        }

        int result = 0;
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int temp = Math.abs(target - sum);
                    if (temp < difference) {
                        difference = temp;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0016_3SumClosest solution = new _0016_3SumClosest();
        int r1 = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println((2 == r1) + " : " + r1);
    }
}
