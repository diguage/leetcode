package com.diguage.algo.leetcode;

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
 */
public class _0039_CombinationSum_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-09 19:54:44
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0 || target <= 0) {
      return Collections.emptyList();
    }
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, 0, result, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] candidates, int target, int start,
                         List<List<Integer>> result, List<Integer> perm) {
    // 子集和等于 target 时，记录解
    if (target == 0) {
      result.add(new ArrayList<>(perm));
      return;
    }
    // 剪枝二：从 start 开始遍历，避免生成重复子集
    for (int i = start; i < candidates.length; i++) {
      int num = candidates[i];
      // 剪枝一：若子集和超过 target ，则直接结束循环
      if (target < num) {
        // 上面排过序，这里直接break
        break;
      }
      perm.add(num);
      backtrack(candidates, target - num, i, result, perm);
      perm.remove(perm.size() - 1);
    }
  }
  // end::answer[]
}
