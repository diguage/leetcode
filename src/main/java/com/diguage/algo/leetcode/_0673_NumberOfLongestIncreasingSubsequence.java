package com.diguage.algo.leetcode;

public class _0673_NumberOfLongestIncreasingSubsequence {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-03 22:54:26
   */
  public int findNumberOfLIS(int[] nums) {
    int n = nums.length, maxLen = 0, result = 0;
    int[] dp = new int[n];
    int[] cnt = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      cnt[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            cnt[i] = cnt[j];
          } else if (dp[j] + 1 == dp[i]) {
            cnt[i] += cnt[j];
          }
        }
      }
      if (dp[i] > maxLen) {
        maxLen = dp[i];
        result = cnt[i];
      } else if (dp[i] == maxLen) {
        result += cnt[i];
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0673_NumberOfLongestIncreasingSubsequence()
      .findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
  }
}
