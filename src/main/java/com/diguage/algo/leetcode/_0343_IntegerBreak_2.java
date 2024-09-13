package com.diguage.algo.leetcode;

public class _0343_IntegerBreak_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 16:08:50
   */
  public int integerBreak(int n) {
    // 1. 确定 dp 数组（dp table）以及下标的含义
    //    dp[i] 表示 i 值被拆分后最大乘积数
    // 3. dp 数组，默认就是0， 0、1拆分后最大乘积就是0，无需初始化
    int[] dp = new int[n + 1];
    // 4. 确定遍历顺序，从 1 → n/2 + 1 逐个遍历
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j < i / 2 + 1; j++) {
        // 2. 确定递推公式: dp[i] = max(j*(i-j), j * dp[i - j])
        dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
      }
    }
    return dp[n];
  }
  // end::answer[]
}
