package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * = 46. Permutations
 *
 * https://leetcode.com/problems/permutations/[Permutations - LeetCode]
 *
 * Given a collection of *distinct* integers, return all possible permutations.
 *
 * .Example:
 * [source]
 * ----
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-24 12:35
 */
public class _0046_Permutations {
    /**
     * Runtime: 5 ms, faster than 8.40% of Java online submissions for Permutations.
     *
     * Memory Usage: 45.3 MB, less than 5.68% of Java online submissions for Permutations.
     *
     * Copy from: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)[A general approach to backtracking questions in Java (Subsets, Permutations, Combination Sum, Palindrome Partioning) - LeetCode Discuss]
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, result, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (path.contains(num)) {
                    continue;
                }
                path.add(num);
                backtrack(nums, result, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        _0046_Permutations solution = new _0046_Permutations();
        int[] n1 = {1, 2, 3};
        List<List<Integer>> r1 = solution.permute(n1);
        System.out.println(Objects.toString(r1));
    }
}
