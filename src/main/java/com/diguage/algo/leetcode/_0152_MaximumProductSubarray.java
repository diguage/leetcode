package com.diguage.algo.leetcode;

/**
 * = 152. Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/[Maximum Product Subarray - LeetCode]
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-05 07:59
 */
public class _0152_MaximumProductSubarray {
  // tag::answer[]
    /**
     * Runtime: 1 ms, faster than 97.91% of Java online submissions for Maximum Product Subarray.
     *
     * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Maximum Product Subarray.
     *
     * Copy form: https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity[Possibly simplest solution with O(n) time complexity - LeetCode Discuss]
     */
    public int maxProduct(int[] nums) {
        // store the result that is the max we have found so far
        int result = nums[0];
        // max/min stores the max/min product of
        // subarray that ends with the current number nums[i]
        for (int i = 1, max = result, min = result; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            min = Math.min(nums[i], min * nums[i]);
            max = Math.max(nums[i], max * nums[i]);

            // the newly computed max value is a candidate for our global result
            result = Math.max(result, max);
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0152_MaximumProductSubarray solution = new _0152_MaximumProductSubarray();
        int[] n1 = {2, 3, -2, 4};
        int r1 = solution.maxProduct(n1);
        System.out.println((r1 == 6) + " : " + r1);

        int[] n2 = {-2, 0, -1};
        int r2 = solution.maxProduct(n2);
        System.out.println((r2 == 0) + " : " + r1);
    }
}
