package com.diguage.algo.leetcode;

/**
 * = 287. Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/[Find the Duplicate Number - LeetCode]
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [1,3,4,2,2]
 * Output: 2
 * ----
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [3,1,3,4,2]
 * Output: 3
 * ----
 *
 * *Note:*
 *
 * . You *must not* modify the array (assume the array is read only).
 * . You must use only constant, O(1) extra space.
 * . Your runtime complexity should be less than O(n^2^).
 * . There is only one duplicate number in the array, but it could be repeated more than once.
 *
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-05 22:52
 */
public class _0287_FindTheDuplicateNumber {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
     * Memory Usage: 42.8 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
     *
     * Copy from: https://leetcode.com/problems/find-the-duplicate-number/solution/[Find the Duplicate Number - LeetCode]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-05 22:52
     */
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        int pointer1 = nums[0];
        int pointer2 = hare;

        while (pointer1 != pointer2) {
            pointer1 = nums[pointer1];
            pointer2 = nums[pointer2];
        }
        return pointer1;
    }

    /**
     * Runtime: 95 ms, faster than 5.83% of Java online submissions for Find the Duplicate Number.
     *
     * Memory Usage: 37.8 MB, less than 37.29% of Java online submissions for Find the Duplicate Number.
     */
    public int findDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0287_FindTheDuplicateNumber solution = new _0287_FindTheDuplicateNumber();
        int[] a1 = {1, 3, 4, 2, 2};
        int r1 = solution.findDuplicate(a1);
        System.out.println((r1 == 2) + " : " + r1);

        int[] a2 = {3, 1, 3, 4, 2};
        int r2 = solution.findDuplicate(a2);
        System.out.println((r2 == 3) + " : " + r2);
    }
}
