package com.diguage.algo.leetcode;

public class _2606_FindTheSubstringWithMaximumCost {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-02 22:39:46
   */
  public int maximumCostSubstring(String s, String chars, int[] vals) {
    int[] values = new int[26];
    for (int i = 0; i < values.length; i++) {
      values[i] = i + 1;
    }
    for (int i = 0; i < vals.length; i++) {
      char c = chars.charAt(i);
      values[c - 'a'] = vals[i];
    }

    int result = 0;
    int[] dp = new int[s.length()];
    dp[0] = values[s.charAt(0) - 'a'];
    result = Math.max(result, dp[0]);
    for (int i = 1; i < s.length(); i++) {
      dp[i] = Math.max(0, dp[i - 1]) + values[s.charAt(i) - 'a'];
      result = Math.max(result, dp[i]);
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _2606_FindTheSubstringWithMaximumCost()
      .maximumCostSubstring("adaa", "d", new int[]{-1000});
  }
}
