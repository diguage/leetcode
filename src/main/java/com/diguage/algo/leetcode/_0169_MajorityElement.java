package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * = 169. Majority Element
 *
 * https://leetcode.com/problems/majority-element/[Majority Element - LeetCode]
 *
 * iven an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * .Example 3:
 * [source]
 * ----
 * Input: [3,2,3]
 * Output: 3
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-05 12:33
 */
public class _0169_MajorityElement {
    // tag::answer[]
    /**
     *Runtime: 2 ms, faster than 61.24% of Java online submissions for Majority Element.
     *
     * Memory Usage: 42.4 MB, less than 59.56% of Java online submissions for Majority Element.
     *
     * Boyer-Moore Voting Algorithm
     *
     * Copy from: https://leetcode.com/problems/majority-element/solution/[Majority Element solution - LeetCode]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-05 12:33
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (0 == count) {
                candidate = num;
            }
            count += candidate == num ? +1 : -1;
        }
        return candidate;
    }

    /**
     * Runtime: 11 ms, faster than 45.56% of Java online submissions for Majority Element.
     *
     * Memory Usage: 40.6 MB, less than 99.26% of Java online submissions for Majority Element.
     */
    public int majorityElementMap(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int num : nums) {
            Integer count = numToCountMap.getOrDefault(num, 0);
            numToCountMap.put(num, count + 1);
        }
        Map.Entry<Integer, Integer> result = null;
        for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
            if (result == null || result.getValue() < entry.getValue()) {
                result = entry;
            }
        }
        return result.getKey();
    }

  // end::answer[]


    public static void main(String[] args) {
        _0169_MajorityElement solution = new _0169_MajorityElement();
        int[] a1 = {3, 2, 3};
        int r1 = solution.majorityElement(a1);
        System.out.println((r1 == 3) + " : " + r1);

        int[] a2 = {2, 2, 1, 1, 1, 2, 2};
        int r2 = solution.majorityElement(a2);
        System.out.println((r2 == 2) + " : " + r2);
    }
}
