package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _2266_CountNumberOfTexts_1b {
  // tag::answer[]

  /**
   * 暴力破解（1/107）-> 备忘录（29.27%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-03 12:12:05
   */
  public int countTexts(String pressedKeys) {
    int mod = 1_000_000_007;
    int[] steps = new int[]{3, 3, 3, 3, 3, 4, 3, 4};
    long result = 1;
    int start = 0;
    char[] chars = pressedKeys.toCharArray();
    long[][] memo = new long[steps.length][chars.length + 1];
    for (long[] m : memo) {
      Arrays.fill(m, -1);
    }
    for (int i = 1; i <= chars.length; i++) {
      if (i < chars.length && chars[i] == chars[i - 1]) {
        continue;
      }
      int index = chars[start] - '2';
      result *= dfs(steps[index], mod, i - start, memo[index]);
      result %= mod;
      start = i;
    }
    return (int) result;
  }

  private long dfs(int steps, int mod, int length, long[] memo) {
    if (length == 0) {
      return 1L;
    }
    if (memo[length] >= 0) {
      return memo[length];
    }
    int result = 0;
    for (int i = 1; i <= steps; i++) {
      if (i > length) {
        break;
      }
      result += dfs(steps, mod, length - i, memo);
      result %= mod;
    }
    return memo[length] = result % mod;
  }
  // end::answer[]

  static void main() {
    new _2266_CountNumberOfTexts_1b()
      .countTexts("22233");
  }
}
