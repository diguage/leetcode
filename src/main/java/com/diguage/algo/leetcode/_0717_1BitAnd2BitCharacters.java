package com.diguage.algo.leetcode;

public class _0717_1BitAnd2BitCharacters {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-25 22:35:59
   */
  public boolean isOneBitCharacter(int[] bits) {
    boolean[][] dp = new boolean[bits.length + 1][2];
    dp[0][0] = true;
    dp[0][1] = true;
    for (int i = 1; i <= bits.length; i++) {
      if (bits[i - 1] == 1) {
        dp[i][0] = false; // 自己不能独立
        if (i < bits.length) {
          // 看看前面是否可以组成合法字符，和后一位组成有效字符
          dp[i + 1][1] = dp[i - 1][0] || dp[i - 1][1];
        }
      } else if (bits[i - 1] == 0) {
        // 自己可以独立，看看前面是否是合法字符
        dp[i][0] = dp[i - 1][0] || dp[i - 1][1];
        if (i > 1) {
          //也可以和前面的字符组成 有效数字
          dp[i][1] = dp[i - 2][0] || dp[i - 2][1];
        }
      }
    }
    return dp[bits.length][0];
  }
  // end::answer[]
}
