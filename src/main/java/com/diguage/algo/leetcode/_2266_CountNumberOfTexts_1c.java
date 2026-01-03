package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _2266_CountNumberOfTexts_1c {
  // tag::answer[]
  /**
   * 暴力破解（1/107）-> 备忘录（29.27%）-> 优化备忘录（60.10%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-03 12:25:05
   */
  public int countTexts(String pressedKeys) {
    int mod = 1_000_000_007;
    int result = 1;
    int start = 0;
    char[] chars = pressedKeys.toCharArray();
    int[] steps = new int[]{3, 4};
    int[][] memo = new int[2][chars.length + 1];
    for (int[] m : memo) {
      Arrays.fill(m, -1);
    }
    for (int i = 1; i <= chars.length; i++) {
      if (i < chars.length && chars[i] == chars[i - 1]) {
        continue;
      }
      int index = (chars[start] == '7' || chars[start] == '9') ? 1 : 0;
      result *= dfs(steps[index], mod, i - start, memo[index]);
      result %= mod;
      start = i;
    }
    return result;
  }

  private int dfs(int steps, int mod, int length, int[] memo) {
    if (length == 0) {
      return 1;
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
    return memo[length] = result;
  }
  // end::answer[]

  static void main() {
    new _2266_CountNumberOfTexts_1c()
      .countTexts("22233");
  }
}
