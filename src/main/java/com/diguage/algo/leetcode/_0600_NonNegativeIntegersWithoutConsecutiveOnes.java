package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0600_NonNegativeIntegersWithoutConsecutiveOnes {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-01 21:31:34
   */
  public int findIntegers(int n) {
    int m = Integer.SIZE - Integer.numberOfLeadingZeros(n);
    int[][] memo = new int[m][2];
    for (int[] row : memo) {
      Arrays.fill(row, -1); // -1 表示没有计算过
    }
    return dfs(m - 1, 0, true, n, memo); // 从高位到低位
  }

  // pre 表示前一个比特位填的数
  private int dfs(int i, int pre, boolean isLimit, int n, int[][] memo) {
    if (i < 0) {
      return 1;
    }
    if (!isLimit && memo[i][pre] >= 0) { // 之前计算过
      return memo[i][pre];
    }
    int up = isLimit ? n >> i & 1 : 1;
    int result = dfs(i - 1, 0, isLimit && up == 0, n, memo); // 填 0
    if (pre == 0 && up == 1) { // 可以填 1
      result += dfs(i - 1, 1, isLimit, n, memo); // 填 1
    }
    if (!isLimit) {
      memo[i][pre] = result; // 记忆化
    }
    return result;
  }
  // end::answer[]
}
