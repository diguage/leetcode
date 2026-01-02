package com.diguage.algo.leetcode;

import java.util.*;

public class _0377_CombinationSumIv_2b {
  // tag::answer[]

  /**
   * 暴力破解（8/17）→ 备忘录（8/17，超过空间限制）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-02 15:59:49
   */
  public int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    Map<Integer, List<List<Integer>>> memo = new HashMap<>();
    List<List<Integer>> result = dfs(nums, target, memo);
    return result.size();
  }

  private List<List<Integer>> dfs(int[] nums, int target,
                                  Map<Integer, List<List<Integer>>> memo) {
    if (target < 0) {
      return null;
    }
    if (memo.containsKey(target)) {
      return memo.get(target);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num > target) {
        break;
      }
      if (num == target) {
        result.add(new ArrayList<>(List.of(target)));
        break;
      }
      List<List<Integer>> list = dfs(nums, target - num, memo);
      if (list != null) {
        for (List<Integer> c : list) {
          c.add(num);
        }
        result.addAll(list);
      }
    }
    memo.put(target, result);
    return result;
  }
  // end::answer[]

  static void main() {
    new _0377_CombinationSumIv_2b()
      .combinationSum4(new int[]{1, 2, 3}, 4);
  }
}
