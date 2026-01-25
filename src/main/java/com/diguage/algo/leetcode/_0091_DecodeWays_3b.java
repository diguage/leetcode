package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _0091_DecodeWays_3b {
  // tag::answer[]

  /**
   * 暴力破解（23/269）-> 备忘录（4.04%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-25 22:59:03
   */
  public int numDecodings(String s) {
    Map<String, String> dict = new HashMap<>();
    for (int i = 1; i <= 26; i++) {
      dict.put(String.valueOf(i), String.valueOf((char) ((i - 1) + 'A')));
    }
    int[] memo = new int[s.length() + 1];
    Arrays.fill(memo, -1);
    return dfs(dict, s, s.length(), memo);
  }

  private int dfs(Map<String, String> dict, String s, int index, int[] memo) {
    if (index < 0) {
      return 0;
    }
    if (memo[index] >= 0) {
      return memo[index];
    }
    if (index == 0) {
      return 1;
    }
    int a = 0;
    String s1 = s.substring(index - 1, index);
    if (dict.containsKey(s1)) {
      a = dfs(dict, s, index - 1, memo);
    }
    int b = 0;
    if (index >= 2) {
      String s2 = s.substring(index - 2, index);
      if (dict.containsKey(s2)) {
        b = dfs(dict, s, index - 2, memo);
      }
    }
    return memo[index] = a + b;
  }
  // end::answer[]
  static void main() {
    new _0091_DecodeWays_3b().numDecodings("226");
  }
}
