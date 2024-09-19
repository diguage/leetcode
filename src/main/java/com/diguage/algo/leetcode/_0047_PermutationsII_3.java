package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047_PermutationsII_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-09 16:41:05
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrack(nums, result, used, new ArrayList<>(nums.length));
    return result;
  }

  private void backtrack(int[] nums, List<List<Integer>> result,
                         boolean[] used, List<Integer> path) {
    if (path.size() == nums.length) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      if (0 < i && nums[i - 1] == nums[i] && !used[i - 1]) {
        continue;
      }
      used[i] = true;
      path.addLast(nums[i]);
      backtrack(nums, result, used, path);
      path.removeLast();
      used[i] = false;
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    _0047_PermutationsII_3 solution = new _0047_PermutationsII_3();
    int[] n1 = {1, 1, 2};
    System.out.println(solution.permuteUnique(n1));
  }
}
