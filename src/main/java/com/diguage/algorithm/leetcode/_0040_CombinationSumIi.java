package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 40. Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/[Combination Sum II - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-27 19:20
 */
public class _0040_CombinationSumIi {
    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Combination Sum II.
     * Memory Usage: 39.5 MB, less than 54.74% of Java online submissions for Combination Sum II.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (Objects.isNull(candidates) || candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, result, new ArrayDeque<>());
        return new ArrayList<>(result);
    }

    private void backtrack(int[] candidates, int beginIndex, int target,
                           List<List<Integer>> result, Deque<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = beginIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                break;
            }
            if (!current.isEmpty() && current.peekLast() > candidate) {
                continue;
            }
            if (beginIndex < i && candidate == candidates[i - 1]) {
                continue;
            }
            current.addLast(candidate);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            backtrack(candidates, i + 1, target - candidate, result, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        _0040_CombinationSumIi solution = new _0040_CombinationSumIi();
        int[] c3 = {1, 2};
        System.out.println(solution.combinationSum2(c3, 4));

        int[] c1 = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(solution.combinationSum2(c1, 8));

        int[] c2 = {2, 5, 2, 1, 2};
        System.out.println(solution.combinationSum2(c2, 5));
    }
}
