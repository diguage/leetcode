package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0516_LongestPalindromicSubsequence_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-24 21:35:23
   */
  public int longestPalindromeSubseq(String s) {
    char[] chars = s.toCharArray();
    int length = s.length();
    int[][] memo = new int[length][length];
    int index = 0;
    for (int[] ints : memo) {
      Arrays.fill(ints, -1);
      ints[index++] = 1;
    }
    return dfs(0, length - 1, chars, memo);
  }

  private int dfs(int i, int j, char[] chars, int[][] memo) {
    if (i > j) {
      return 0;
    }
//    if (i == j) {
//      return 1;
//    }
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    if (chars[i] == chars[j]) {
      return memo[i][j] = dfs(i + 1, j - 1, chars, memo) + 2;
    }
    return memo[i][j] = Math.max(dfs(i + 1, j, chars, memo),
      dfs(i, j - 1, chars, memo));
  }
  // end::answer[]

  static void main() {
    new _0516_LongestPalindromicSubsequence_2()
      .longestPalindromeSubseq("abcdefga");
  }
}
