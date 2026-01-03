package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _2466_CountWaysToBuildGoodStrings_2c {
  // tag::answer[]

  /**
   * 暴力破解（14/36）-> 备忘录（12.65%）-> 动态规划（33.45%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-03 10:27:06
   */
  public int countGoodStrings(int low, int high, int zero, int one) {
    int mod = 1_000_000_007;
    // f(i) = f(i-zero) + f(i-one)
    int[] dp = new int[high + 1];
    dp[0] = 1;
    int[] steps = {zero, one};
    Arrays.sort(steps);
    for (int i = 0; i <= high - steps[0]; i++) {
      for (int step : steps) {
        if (i + step > high) {
          break;
        }
        dp[i + step] += dp[i];
        dp[i + step] %= mod;
      }
    }
    int result = 0;
    for (int i = low; i <= high; i++) {
      result += dp[i];
      result %= mod;
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _2466_CountWaysToBuildGoodStrings_2c()
      .countGoodStrings(3, 3, 1, 1);
  }
}
