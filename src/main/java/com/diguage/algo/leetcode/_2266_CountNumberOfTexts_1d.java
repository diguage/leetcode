package com.diguage.algo.leetcode;

public class _2266_CountNumberOfTexts_1d {
  // tag::answer[]

  /**
   * 暴力破解（1/107）-> 备忘录（29.27%）-> 优化备忘录（60.10%）-> 动态规划（88.08%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-03 12:25:05
   */
  public int countTexts(String pressedKeys) {
    int mod = 1_000_000_007;
    char[] chars = pressedKeys.toCharArray();
    int[] lengths = getLength(chars);
    long[][] dp = new long[2][];
    dp[0] = new long[lengths[0] + 1];
    dp[0][0] = 1;
    for (int i = 0; i < dp[0].length; i++) {
      for (int j = 1; j <= 3; j++) {
        if (i + j >= dp[0].length) {
          break;
        }
        dp[0][i + j] += dp[0][i];
        dp[0][i + j] %= mod;
      }
    }
    dp[1] = new long[lengths[1] + 1];
    dp[1][0] = 1;
    for (int i = 0; i < dp[1].length; i++) {
      for (int j = 1; j <= 4; j++) {
        if (i + j >= dp[1].length) {
          break;
        }
        dp[1][i + j] += dp[1][i];
        dp[1][i + j] %= mod;
      }
    }
    long result = 1;
    int start = 0;
    for (int i = 1; i <= chars.length; i++) {
      if (i < chars.length && chars[i] == chars[i - 1]) {
        continue;
      }
      int index = (chars[start] == '7' || chars[start] == '9') ? 1 : 0;
      result *= dp[index][i - start];
      result %= mod;
      start = i;
    }
    return (int) result;
  }

  private int[] getLength(char[] chars) {
    int[] result = new int[2];
    int start = 0;
    for (int i = 1; i <= chars.length; i++) {
      if (i < chars.length && chars[i] == chars[i - 1]) {
        continue;
      }
      int index = (chars[start] == '7' || chars[start] == '9') ? 1 : 0;
      result[index] = Math.max(result[index], i - start);
      start = i;
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _2266_CountNumberOfTexts_1d()
//      .countTexts("22233");
      .countTexts("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664");
  }
}
