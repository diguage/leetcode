package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * = 39. Combination Sum
 * <p>
 * https://leetcode.com/problems/combination-sum/description/[Combination Sum - LeetCode]
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where
 * the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * *Note:*
 * <p>
 * * All numbers (including target) will be positive integers.
 * * The solution set must not contain duplicate combinations.
 * <p>
 * .Example 1:
 * [source]
 * ----
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * ----
 * <p>
 * .Example 2:
 * [source]
 * ----
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2018-09-16 21:56
 */
public class _0039_CombinationSum {
    /**
     * Runtime: 164 ms, faster than 5.05% of Java online submissions for Combination Sum.
     * Memory Usage: 45.5 MB, less than 5.19% of Java online submissions for Combination Sum.
     * <p>
     * ↓
     * <p>
     * Runtime: 9 ms, faster than 17.31% of Java online submissions for Combination Sum.
     * Memory Usage: 41 MB, less than 5.19% of Java online submissions for Combination Sum.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (null == candidates || candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        }
        if (target < 0) {
            return;
        }
        for (int candidate : candidates) {
            if (!current.isEmpty() && current.get(current.size() - 1) > candidate) {
                continue;
            }
            current.add(candidate);
            backtrack(candidates, target - candidate, result, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        _0039_CombinationSum solution = new _0039_CombinationSum();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
