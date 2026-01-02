package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0377_CombinationSumIv_2a {
  // tag::answer[]

  /**
   * 暴力破解（8/17）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-02 14:55:07
   */
  public int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = dfs(nums, target);
    return result.size();
  }

  private List<List<Integer>> dfs(int[] nums, int target) {
    if (target < 0) {
      return null;
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
      List<List<Integer>> list = dfs(nums, target - num);
      if (list != null) {
        for (List<Integer> c : list) {
          c.add(num);
        }
        result.addAll(list);
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0377_CombinationSumIv_2a()
      .combinationSum4(new int[]{1, 2, 3}, 4);
  }
}
