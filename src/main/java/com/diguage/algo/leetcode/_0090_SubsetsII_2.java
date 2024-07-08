package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 90. Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/[Subsets II - LeetCode]
 */
public class _0090_SubsetsII_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-08 21:31:11
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // 对数组进行排序，方便后续处理相同的元素
    backtrack(nums, 0, result, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] nums, int start,
                         List<List<Integer>> result, List<Integer> subset) {
    result.add(new ArrayList<>(subset));
    for (int i = start; i < nums.length; i++) {
      // 在同一父节点下的递归子树，对值相同的节点进行剪枝
      if (start < i && nums[i - 1] == nums[i]) {
        continue;
      }
      subset.add(nums[i]);
      backtrack(nums, i + 1, result, subset);
      subset.remove(subset.size() - 1);
    }
  }
  // end::answer[]
}
