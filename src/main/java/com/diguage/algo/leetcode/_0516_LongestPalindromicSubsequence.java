package com.diguage.algo.leetcode;

public class _0516_LongestPalindromicSubsequence {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-19 21:32:01
   */
  public int longestPalindromeSubseq(String s) {
    int length = s.length();
    int[][] dp = new int[length][length];
    for (int i = length - 1; i >= 0; i--) {
      dp[i][i] = 1;
      char ic = s.charAt(i);
      for (int j = i + 1; j < length; j++) {
        char jc = s.charAt(j);
        if (ic == jc) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][length - 1];
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0516_LongestPalindromicSubsequence().longestPalindromeSubseq("ababa");
  }
}
