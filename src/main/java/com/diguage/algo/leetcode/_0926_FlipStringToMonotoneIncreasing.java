package com.diguage.algo.leetcode;

public class _0926_FlipStringToMonotoneIncreasing {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-24 17:54:37
   */
  public int minFlipsMonoIncr(String s) {
    // 1. 确定 dp 数组（dp table）以及下标的含义
    //    对于 0≤i<n，用 dp[i][0] 和 dp[i][1] 分别表示下标 i 处的
    //    字符为 0 和 1 的情况下使得 s[0..i] 单调递增的最小翻转次数。
    //   如果下标 i 处的字符是 0，则只有当下标 i−1 处的字符是 0 时才符合
    //   单调递增；如果下标 i 处的字符是 1，则下标 i−1 处的字符是 0 或 1
    //   都符合单调递增，此时为了将翻转次数最小化，应分别考虑下标 i−1 处的
    //   字符是 0 和 1 的情况下需要的翻转次数，取两者的最小值。
    int[][] dp = new int[s.length() + 1][2];
    // 3. dp 数组如何初始化
    dp[0][0] = 0;
    dp[0][1] = 0;
    // 4. 确定遍历顺序
    for (int i = 1; i <= s.length(); i++) {
      boolean isZero = s.charAt(i - 1) == '0';
      // 2. 确定递推公式
      dp[i][0] = dp[i - 1][0] + (!isZero ? 1 : 0);
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (isZero ? 1 : 0);
    }
    return Math.min(dp[s.length()][0], dp[s.length()][1]);
  }
  // end::answer[]
}
