package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0377_CombinationSumIv_2d {
  // tag::answer[]

  /**
   * 原始方案走不通，加备忘录会内存🇰超限。看题解，改成爬楼梯解法。
   * <p>
   * 暴力破解（10/17）-> 备忘录（6.27%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-02 16:17:16
   */
  public int combinationSum4(int[] nums, int target) {
    int[] memo = new int[target + 1];
    Arrays.fill(memo, -1);
    Arrays.sort(nums);
    return dfs(nums, target, memo);
  }

  private int dfs(int[] nums, int target, int[] memo) {
    if (target == 0) {
      return 1;
    }
    if (memo[target] >= 0) {
      return memo[target];
    }
    int result = 0;
    for (int num : nums) {
      if (num > target) {
        break;
      }
      result += dfs(nums, target - num, memo);
    }
    memo[target] = result;
    return result;
  }
  // end::answer[]

  static void main() {
    new _0377_CombinationSumIv_2d()
      .combinationSum4(new int[]{1, 2, 3}, 4);
  }
}
