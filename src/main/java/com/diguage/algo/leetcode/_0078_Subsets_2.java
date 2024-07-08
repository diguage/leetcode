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
 */
public class _0078_Subsets_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-08 21:15:30
   */
  public List<List<Integer>> subsets(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, result, new ArrayList<Integer>());
    return result;
  }

  private void backtrack(int[] nums, int start,
                         List<List<Integer>> result, List<Integer> subset) {
    result.add(new ArrayList<>(subset));
    for (int i = start; i < nums.length; i++) {
      subset.add(nums[i]);
      backtrack(nums, i + 1, result, subset);
      subset.remove(subset.size() - 1);
    }
  }
  // end::answer[]
}
