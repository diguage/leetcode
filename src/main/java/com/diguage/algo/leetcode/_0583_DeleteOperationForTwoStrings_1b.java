package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0583_DeleteOperationForTwoStrings_1b {
  // tag::answer[]

  /**
   * 暴力破解（24/1306）-> 备忘录（7.12%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-23 21:18:06
   */
  public int minDistance(String word1, String word2) {
    Map<Integer, Integer> memo = new HashMap<>();
    return dfs(word1, word1.length() - 1, word2, word2.length() - 1, memo);
  }

  private int dfs(String word1, int i, String word2, int j, Map<Integer, Integer> memo) {
    if (i < 0 || j < 0) {
      return Math.max(i, j) + 1;
    }
    int key = 1000 * i + j;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }
    if (word1.charAt(i) == word2.charAt(j)) {
      int result = dfs(word1, i - 1, word2, j - 1, memo);
      memo.put(key, result);
      return result;
    } else {
      int result = Math.min(dfs(word1, i - 1, word2, j, memo),
        dfs(word1, i, word2, j - 1, memo)) + 1;
      memo.put(key, result);
      return result;
    }
  }

  // end::answer[]
  static void main() {
    new _0583_DeleteOperationForTwoStrings_1b()
      .minDistance("sea", "eat");
  }
}
