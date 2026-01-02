package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0377_CombinationSumIv_2e {
  // tag::answer[]

  /**
   * 原始方案走不通，加备忘录会内存🇰超限。看题解，改成爬楼梯解法。
   * <p>
   * 暴力破解（10/17）-> 备忘录（6.27%）-> 动态规划（4.73%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-02 16:20:32
   */
  public int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 0; i <= target; i++) {
      for (int num : nums) {
        if (num + i > target) {
          break;
        }
        dp[i + num] += dp[i];
      }
    }
    return dp[target];
  }

  // end::answer[]

  static void main() {
    new _0377_CombinationSumIv_2e()
      .combinationSum4(new int[]{1, 2, 3}, 4);
  }
}
