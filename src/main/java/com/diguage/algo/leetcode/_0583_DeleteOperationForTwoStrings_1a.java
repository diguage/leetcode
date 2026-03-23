package com.diguage.algo.leetcode;

public class _0583_DeleteOperationForTwoStrings_1a {
  // tag::answer[]

  /**
   * 通过 24 / 1306 个测试用例，超时
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-23 21:18:06
   */
  public int minDistance(String word1, String word2) {
    return dfs(word1, word1.length() - 1, word2, word2.length() - 1);
  }

  private int dfs(String word1, int i, String word2, int j) {
    if (i < 0 || j < 0) {
      return Math.max(i, j) + 1;
    }
    if (word1.charAt(i) == word2.charAt(j)) {
      return dfs(word1, i - 1, word2, j - 1);
    } else {
      return Math.min(dfs(word1, i - 1, word2, j),
        dfs(word1, i, word2, j - 1)) + 1;
    }
  }

  // end::answer[]
  static void main() {
    new _0583_DeleteOperationForTwoStrings_1a()
      .minDistance("sea", "eat");
  }
}
