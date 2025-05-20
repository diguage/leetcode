package com.diguage.algo.leetcode;

public class _0091_DecodeWays_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-20 16:13:52
   */
  public int numDecodings(String s) {
    if (s.charAt(0) == '0') {
      return 0;
    }
    int[] dp = new int[s.length() + 1];
    dp[0] = 1; // 没有字符也是一种解码方案（主要是为了保证后续递推的正确性）
    for (int i = 1; i <= s.length(); i++) {
      int val = s.charAt(i - 1) - '0';
      if (val != 0) {
        dp[i] = dp[i - 1];
      }
      if (i >= 2) {
        int pre = (s.charAt(i - 2) - '0') * 10;
        int sum = pre + val;
        if (sum >= 10 && sum <= 26) {
          dp[i] += dp[i - 2];
        }
      }
    }
    return dp[s.length()];
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0091_DecodeWays_2().numDecodings("2101");
  }
}
