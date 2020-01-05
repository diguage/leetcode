package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * = 217. Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate/[Contains Duplicate - LeetCode]
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [1,2,3,1]
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [1,2,3,4]
 * Output: false
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-05 20:01
 */
public class ContainsDuplicate {
    /**
     * Runtime: 9 ms, faster than 58.06% of Java online submissions for Contains Duplicate.
     *
     * Memory Usage: 44.4 MB, less than 57.76% of Java online submissions for Contains Duplicate.
     */
    public boolean containsDuplicate(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return false;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            } else {
                numSet.add(num);
            }
        }
        return false;
    }

    /**
     * Runtime: 5 ms, faster than 96.50% of Java online submissions for Contains Duplicate.
     *
     * Memory Usage: 42.1 MB, less than 98.28% of Java online submissions for Contains Duplicate.
     */
    public boolean containsDuplicateSort(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        int[] n1 = {1, 2, 3, 1};
        boolean r1 = solution.containsDuplicate(n1);
        System.out.println(r1);
    }
}
