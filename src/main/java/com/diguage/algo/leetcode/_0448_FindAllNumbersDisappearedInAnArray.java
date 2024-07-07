package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * = 448. Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/[Find All Numbers Disappeared in an Array - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-29 19:06
 */
public class _0448_FindAllNumbersDisappearedInAnArray {
  // tag::answer[]
    /**
     * Runtime: 5 ms, faster than 91.55% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 48.5 MB, less than 33.96% of Java online submissions for Find All Numbers Disappeared in an Array.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * Runtime: 21 ms, faster than 26.28% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 53.1 MB, less than 15.09% of Java online submissions for Find All Numbers Disappeared in an Array.
     */
    public List<Integer> findDisappearedNumbersMap(int[] nums) {
        Set<Integer> result = new HashSet<>(nums.length);
        for (int i = 1; i <= nums.length; i++) {
            result.add(i);
        }
        for (int num : nums) {
            result.remove(num);
        }
        return new ArrayList<>(result);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0448_FindAllNumbersDisappearedInAnArray solution = new _0448_FindAllNumbersDisappearedInAnArray();
        int[] n1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDisappearedNumbers(n1));
    }
}
