package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 47. Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/[Permutations II - LeetCode]
 */
public class _0047_PermutationsII_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-09 16:41:05
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    Arrays.sort(nums);
    backtrack(nums, used, result, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] nums, boolean[] used,
                         List<List<Integer>> result, List<Integer> perm) {
    if (perm.size() == nums.length) {
      result.add(new ArrayList<>(perm));
      return;
    }
    // 前面进行了排序，
    // 如果不排序，也可以使用Set来记录同一层元素的使用情况，重复就跳过
    int pre = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (used[i] || nums[i] == pre) {
        continue;
      }
      used[i] = true;
      pre = nums[i];
      perm.add(nums[i]);
      backtrack(nums, used, result, perm);
      perm.remove(perm.size() - 1);
      used[i] = false;
    }
  }
  // end::answer[]
}
