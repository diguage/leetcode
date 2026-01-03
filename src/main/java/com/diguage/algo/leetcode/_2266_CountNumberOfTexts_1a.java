package com.diguage.algo.leetcode;

public class _2266_CountNumberOfTexts_1a {
  // tag::answer[]

  /**
   * 暴力破解（1/107）->
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-03 11:09:55
   */
  public int countTexts(String pressedKeys) {
    int mod = 1_000_000_007;
    int[] steps = new int[]{3, 3, 3, 3, 3, 4, 3, 4};
    int result = 1;
    int start = 0;
    char[] chars = pressedKeys.toCharArray();
    for (int i = 1; i <= chars.length; i++) {
      if (i < chars.length && chars[i] == chars[i - 1]) {
        continue;
      }
      result *= dfs(steps[chars[start] - '2'], mod, i - start);
      result %= mod;
      start = i;
    }
    return result;
  }

  private int dfs(int steps, int mod, int length) {
    if (length == 0) {
      return 1;
    }
    int result = 0;
    for (int i = 1; i <= steps; i++) {
      if (i > length) {
        break;
      }
      result += dfs(steps, mod, length - i);
      result %= mod;
    }
    return result % mod;
  }
  // end::answer[]

  static void main() {
    new _2266_CountNumberOfTexts_1a()
      .countTexts("22233");
  }
}
