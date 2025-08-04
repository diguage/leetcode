package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0413_ArithmeticSlices {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-04 21:13:37
   */
  public int numberOfArithmeticSlices(int[] nums) {
    Set<String> memo = new HashSet<>();
    for (int i = 2; i < nums.length; i++) {
      dfs(nums, memo, nums[i - 1] - nums[i - 2], i - 2, i);
    }
    return memo.size();
  }

  private void dfs(int[] nums, Set<String> memo, int diff, int start, int next) {
    if (next >= nums.length) {
      return;
    }
    if (nums[next] - nums[next - 1] == diff) {
      memo.add(start + "/" + next);
      dfs(nums, memo, diff, start, next + 1);
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0413_ArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
  }
}
