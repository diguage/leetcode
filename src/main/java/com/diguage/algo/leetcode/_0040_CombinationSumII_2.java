package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 40. Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/[Combination Sum II - LeetCode]
 */
public class _0040_CombinationSumII_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-10 16:52:25
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(candidates, result, 0, target, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] can, List<List<Integer>> result,
                         int start, int target, List<Integer> com) {
    // 子集和等于 target 时，记录解
    if (target == 0) {
      result.add(new ArrayList<>(com));
      return;
    }
    // 剪枝二：从 start 开始遍历，避免生成重复子集
    // 剪枝三：从 start 开始遍历，避免重复选择同一元素
    for (int i = start; i < can.length; i++) {
      // 剪枝一：若子集和超过 target ，则直接结束循环
      // 这是因为数组已排序，后边元素更大，子集和一定超过 target
      if (target < can[i]) {
        break;
      }
      // 剪枝四：如果该元素与左边元素相等，说明该搜索分支重复，直接跳过
      if (start < i && can[i - 1] == can[i]) {
        continue;
      }
      com.add(can[i]);
      // 进行下一轮选择
      backtrack(can, result, i + 1, target - can[i], com);
      com.remove(com.size() - 1);
    }
  }
  // end::answer[]
}
