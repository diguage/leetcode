package com.diguage.algo.leetcode;

import java.util.Arrays;

/**
 * = 238. Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/[Product of Array Except Self - LeetCode]
 *
 * Given an array `nums` of `n` integers where `n > 1`,  return an array `output` such that `output[i]` is equal to the product of all the elements of `nums` except `nums[i]`.
 *
 * .Example:
 * [source]
 * ----
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * ----
 *
 * *Note:* Please solve it *without division* and in O(n).
 *
 * *Follow up:*
 *
 * Could you solve it with constant space complexity? (The output array *does not* count as extra space for the purpose of space complexity analysis.)
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-05 20:15
 */
public class _0238_ProductOfArrayExceptSelf {
  // tag::answer[]
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
     *
     * Memory Usage: 42.8 MB, less than 48.03% of Java online submissions for Product of Array Except Self.
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
     *
     * Memory Usage: 42.8 MB, less than 48.03% of Java online submissions for Product of Array Except Self.
     */
    public int[] productExceptSelfDivision(int[] nums) {
        int product = 1;
        int zero = nums.length;
        for (int num : nums) {
            if (num == 0) {
                zero++;
                continue;
            }
            product *= num;
        }

        int[] result = new int[nums.length];
        if (zero >= nums.length + 2) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                result[i] = product;
            } else {
                if (zero == nums.length + 1) {
                    result[i] = 0;
                } else {
                    result[i] = product / num;
                }
            }
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0238_ProductOfArrayExceptSelf solution = new _0238_ProductOfArrayExceptSelf();
        int[] a1 = {1, 2, 3, 4};
        int[] r1 = solution.productExceptSelf(a1);
        int[] sr1 = {24, 12, 8, 6};
        System.out.println(Arrays.equals(r1, sr1) + " : " + Arrays.toString(r1));

        int[] a2 = {0, 0};
        int[] r2 = solution.productExceptSelf(a2);
        int[] sr2 = {0, 0};
        System.out.println(Arrays.equals(r2, sr2) + " : " + Arrays.toString(r2));
    }
}
