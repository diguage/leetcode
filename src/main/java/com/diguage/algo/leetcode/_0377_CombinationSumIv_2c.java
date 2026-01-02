package com.diguage.algo.leetcode;

import java.util.*;

public class _0377_CombinationSumIv_2c {
  // tag::answer[]

  /**
   * 原始方案走不通，加备忘录会内存🇰超限。看题解，改成爬楼梯解法。
   * <p>
   * 暴力破解（10/17）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-02 16:14:56
   */
  public int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    return dfs(nums, target);
  }

  private int dfs(int[] nums, int target) {
    if (target == 0) {
      return 1;
    }
    int result = 0;
    for (int num : nums) {
      if (num > target) {
        break;
      }
      result += dfs(nums, target - num);
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0377_CombinationSumIv_2c()
      .combinationSum4(new int[]{1, 2, 3}, 4);
  }
}
