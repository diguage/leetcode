package com.diguage.algo.leetcode;

public class _0300_LongestIncreasingSubsequence_4c {
  // tag::answer[]

  /**
   * 暴力破解（23/56）-> 备忘录（5.03%）-> 动态规划（48.89%）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-20 21:06:06
   */
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    int result = 0;
    for (int i = 0; i < n; i++) {
      // dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          // dp[i]=max(dp[i], dp[j]+1)
          dp[i] = Math.max(dp[j], dp[i]);
        }
      }
      result = Math.max(result, ++dp[i]);
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0300_LongestIncreasingSubsequence_4c()
      .lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
//      .lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
  }
}
