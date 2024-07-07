package com.diguage.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * = 78. Subsets
 *
 * https://leetcode.com/problems/subsets/[Subsets - LeetCode]
 *
 * Given a set of *distinct* integers, nums, return all possible subsets (the power set).
 *
 * *Note:* The solution set must not contain duplicate subsets.
 *
 * .Example:
 * [source]
 * ----
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-02 19:56
 */
public class _0078_Subsets {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
     * 
     * Memory Usage: 37.1 MB, less than 99.18% of Java online submissions for Subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> current : result) {
                ArrayList<Integer> integers = new ArrayList<>(current);
                integers.add(num);
                newSubsets.add(integers);
            }
            result.addAll(newSubsets);
        }
        return result;
    }

    /**
     * Runtime: 74 ms, faster than 5.06% of Java online submissions for Subsets.
     *
     * Memory Usage: 50.3 MB, less than 5.74% of Java online submissions for Subsets.
     */
    public List<List<Integer>> subsetsLevel(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return Collections.emptyList();
        }
        Set<Set<Integer>> subsets = new HashSet<>();
        subsets.add(Collections.emptySet());
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Set<Integer>> list = new ArrayList<>(subsets);
            list.forEach(s -> {
                for (int num : nums) {
                    Set<Integer> set = new TreeSet<>(s);
                    set.add(num);
                    subsets.add(set);
                }
            });
        }
        List<List<Integer>> result = subsets.stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0078_Subsets solution = new _0078_Subsets();
        int[] a1 = {1, 2, 3};
        List<List<Integer>> r1 = solution.subsets(a1);
        System.out.println(r1);
    }
}
